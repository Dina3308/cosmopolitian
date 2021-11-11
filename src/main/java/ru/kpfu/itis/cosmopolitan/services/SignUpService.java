package ru.kpfu.itis.cosmopolitan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.cosmopolitan.dto.UserSignUpForm;
import ru.kpfu.itis.cosmopolitan.models.Basket;
import ru.kpfu.itis.cosmopolitan.models.User;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.BasketRepository;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.UserRepository;
import ru.kpfu.itis.cosmopolitan.utils.exceptions.AuthException;

@Service
public class SignUpService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BasketRepository basketRepository;

    public void signUp(UserSignUpForm form) throws AuthException {
        if(!form.getPassword().equals(form.getRepeatPassword())){
            throw new AuthException("пароли не совпадают");
        }
        else if(userRepository.findByEmail(form.getEmail()).isPresent()){
            throw new AuthException("такой email уже существует");
        }
        else {
            User user = User.builder()
                    .name(form.getName())
                    .surname(form.getSurname())
                    .email(form.getEmail())
                    .role(User.Role.USER)
                    .hashPassword(passwordEncoder.encode(form.getPassword()))
                    .build();
            userRepository.save(user);

            Basket basket = Basket.builder()
                    .user(user)
                    .build();
            basketRepository.save(basket);
        }
    }
}
