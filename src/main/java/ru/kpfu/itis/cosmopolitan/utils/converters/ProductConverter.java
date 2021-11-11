package ru.kpfu.itis.cosmopolitan.utils.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.kpfu.itis.cosmopolitan.dto.ProductDto;
import ru.kpfu.itis.cosmopolitan.services.ProductService;
import java.util.List;

public class ProductConverter implements Converter<String, List<ProductDto>> {

    @Autowired
    ProductService productService;

    @Override
    public List<ProductDto> convert(String category) {
        return productService.getProductsByCategory(category);
    }
}
