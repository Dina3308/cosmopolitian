package ru.kpfu.itis.cosmopolitan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kpfu.itis.cosmopolitan.dto.ProductDto;
import ru.kpfu.itis.cosmopolitan.utils.converters.ProductConverter;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public Converter<String, List<ProductDto>> productConverter() {
        return new ProductConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(productConverter());
    }
}
