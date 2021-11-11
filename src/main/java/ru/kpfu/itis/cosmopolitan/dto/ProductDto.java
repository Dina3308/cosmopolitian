package ru.kpfu.itis.cosmopolitan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.cosmopolitan.models.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String productName;
    private String category;
    private int productPrice;
    private int productCount;
    private String productImg;
    private String description;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .category(product.getCategory())
                .description(product.getDescription())
                .productCount(product.getProductCount())
                .productName(product.getProductName())
                .productImg(product.getProductImg())
                .productPrice(product.getProductPrice())
                .build();
    }

    public static ProductDto from(Product product, int count, int price) {
        return ProductDto.builder()
                .id(product.getId())
                .category(product.getCategory())
                .description(product.getDescription())
                .productCount(count)
                .productName(product.getProductName())
                .productImg(product.getProductImg())
                .productPrice(price)
                .build();
    }

    public static List<ProductDto> from(List<Product> products) {
        return products.stream()
                .map(ProductDto::from)
                .collect(Collectors.toList());
    }

}
