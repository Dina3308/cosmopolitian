package ru.kpfu.itis.cosmopolitan.dto;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class ProductForm {
    @NotBlank(message = "Пожалуйста, заполните название товара")
    private String productName;

    @NotBlank(message = "Пожалуйста, заполните категорие товара")
    private String category;

    @NotNull(message = "Пожалуйста, укажите цену товара в долларах")
    private Integer productPrice;

    @NotNull(message = "Пожалуйста, укажите количество товара")
    private Integer productCount;

    private MultipartFile productImg;

    @NotBlank(message = "Пожалуйста, заполните описание товара")
    private String description;
}
