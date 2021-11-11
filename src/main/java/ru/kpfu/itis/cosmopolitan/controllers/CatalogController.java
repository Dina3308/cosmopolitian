package ru.kpfu.itis.cosmopolitan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.cosmopolitan.dto.ProductDto;
import ru.kpfu.itis.cosmopolitan.security.details.UserDetailsImpl;
import ru.kpfu.itis.cosmopolitan.services.ProductService;
import ru.kpfu.itis.cosmopolitan.services.BasketService;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    ProductService productService;

    @Autowired
    BasketService basketService;

    @GetMapping("/catalog")
    public String getCatalogPage(@RequestParam(defaultValue = "нормальная") List<ProductDto> category, @AuthenticationPrincipal UserDetailsImpl user, Model model){
        if(user != null){
            model.addAttribute("baskets", basketService.read(user.getUser()));
        }
        model.addAttribute("products", category);
        return "catalog";
    }

    @GetMapping("/catalog/populars")
    public String getCatalogPage(@AuthenticationPrincipal UserDetailsImpl user, Model model){
        if(user != null){
            model.addAttribute("baskets", basketService.read(user.getUser()));
        }
        model.addAttribute("products", productService.getPopularProducts());
        return "catalog";
    }
}
