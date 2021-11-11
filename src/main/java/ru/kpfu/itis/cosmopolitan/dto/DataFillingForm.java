package ru.kpfu.itis.cosmopolitan.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Validated
public class DataFillingForm {

    @NotBlank(message = "Пожалуйста, заполните имя")
    private String name;

    @NotBlank(message = "Пожалуйста, заполните фамилию")
    private String surname;

    @NotBlank(message = "Пожалуйста, заполните email")
    @Email(message = "Некорректный email")
    private String email;

    @NotBlank(message = "Пожалуйста, заполните номер телефона")
    @Pattern(regexp = "^([+]?[0-9\\s-\\(\\)]{10,25})*$", message = "Некорректный номер")
    private String numberPhone;

    @NotBlank(message = "Пожалуйста, заполните это поле")
    private String region;

    @NotBlank(message = "Пожалуйста, заполните город")
    private String city;

    @NotBlank(message = "Пожалуйста, заполните это поле")
    private String street;

    @NotBlank(message = "Пожалуйста, заполните почтовый индекс")
    @Pattern(regexp = "^\\d{6}$", message = "некорректный почтовый индекс")
    private String index;

    @NotBlank(message = "Пожалуйста, заполните номер карты")
    @Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$", message = "некорректный номер карты")
    private String cardNumber;

    @NotBlank(message = "Пожалуйста, заполните cvv")
    @Pattern(regexp = "^[0-9]{3,4}$", message = "некорректный сvv")
    private String cvv;

    @NotBlank(message = "Пожалуйста, заполните месяц")
    @Pattern(regexp = "0[1-9]|1[012]", message = "некорректный месяц")
    private String month;

    @NotBlank(message = "Пожалуйста, заполните год")
    @Pattern(regexp = "2[1-9]", message = "некорректный год")
    private String year;
}
