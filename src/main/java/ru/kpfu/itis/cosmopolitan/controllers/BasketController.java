package ru.kpfu.itis.cosmopolitan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.cosmopolitan.dto.BasketDto;
import ru.kpfu.itis.cosmopolitan.security.details.UserDetailsImpl;
import ru.kpfu.itis.cosmopolitan.services.BasketService;

import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/basket")
    public String getBasketPage(@AuthenticationPrincipal UserDetailsImpl user, Model model){
        List<BasketDto> list = basketService.read(user.getUser());
        if(list.size() > 0){
            model.addAttribute("baskets", list);
        }
        return "basket";
    }
}
