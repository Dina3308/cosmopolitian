package ru.kpfu.itis.cosmopolitan.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Validated
public class UserSignUpForm {

    @NotBlank(message = "Пожалуйста, заполните имя")
    private String name;

    @NotBlank(message = "Пожалуйста, заполните фамилию")
    private String surname;

    @NotBlank(message = "Пожалуйста, заполните email")
    @Email(message = "Некорректный email")
    private String email;

    @NotBlank(message = "Пожалуйста, заполните пароль")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Пароль должен содержать не менее 6 символов, хотя бы одну цифру, прописную  и заглавную латинскую букву")
    private String password;

    @NotBlank(message = "Пожалуйста, заполните пароль еще раз")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Пароль должен содержать не менее 6 символов, хотя бы одну цифру, прописную  и заглавную латинскую букву")
    private String repeatPassword;
}

