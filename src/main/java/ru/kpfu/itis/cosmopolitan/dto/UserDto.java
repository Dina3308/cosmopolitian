package ru.kpfu.itis.cosmopolitan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.cosmopolitan.models.Product;
import ru.kpfu.itis.cosmopolitan.models.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String surname;

    private String name;

    private String email;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .surname(user.getSurname())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
