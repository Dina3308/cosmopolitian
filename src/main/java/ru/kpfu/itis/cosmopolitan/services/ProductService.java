package ru.kpfu.itis.cosmopolitan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.cosmopolitan.dto.ProductDto;
import ru.kpfu.itis.cosmopolitan.dto.ProductForm;
import ru.kpfu.itis.cosmopolitan.models.Product;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.ProductRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void create(ProductForm form) {
        try {
            form.getProductImg().transferTo(new File("C:\\Users\\dinar\\IdeaProjects\\cosmopolitan\\src\\main\\resources\\static\\img\\"+form.getProductImg().getOriginalFilename()));
            Product product = Product.builder()
                    .productName(form.getProductName())
                    .productCount(form.getProductCount())
                    .productImg(form.getProductImg().getOriginalFilename())
                    .productPrice(form.getProductPrice())
                    .description(form.getDescription())
                    .category(form.getCategory())
                    .build();

            productRepository.save(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return ProductDto.from(products);
    }

    public List<String> getCountProductsSold(){
        List<String> products = new ArrayList<>();
        List<Object[]> productsSold = productRepository.getCountOfProductsSold();
        List<ProductDto> productDtos = getAllProducts();
        for (int i = 0; i < productDtos.size(); i++ ){
            String count = "0";
            for (int j = 0; j < productsSold.size(); j++){
                if(productDtos.get(i).getId().toString().equals(productsSold.get(j)[0].toString())){
                    count = productsSold.get(j)[1].toString();
                    break;
                }
            }
            products.add(count);
        }
        return products;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }


    public ProductDto update(Long id, int count) {
        Product product = productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        product.setProductCount(count);
        productRepository.save(product);
        return ProductDto.from(product);
    }

    public List<ProductDto> getAllNotNullCountProducts() {
        List<Product> products = productRepository.findProductsByProductCountGreaterThan(0);
        return ProductDto.from(products);
    }

    public List<ProductDto> getProductsByCategory(String category) {
        List<Product> products = productRepository.findProductsByCategoryAndProductCountGreaterThan(category, 0);
        if(category.equals("популярные")){
           return getPopularProducts();
        }
        return ProductDto.from(products);
    }

    public List<ProductDto> getPopularProducts() {
        List<Product> products = productRepository.findProductsByCategoryDescByCount();
        return ProductDto.from(products);
    }

}
