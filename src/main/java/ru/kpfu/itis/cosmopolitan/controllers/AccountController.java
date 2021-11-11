package ru.kpfu.itis.cosmopolitan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.cosmopolitan.security.details.UserDetailsImpl;
import ru.kpfu.itis.cosmopolitan.services.OrderService;

@Controller
public class AccountController {

    @Autowired
    OrderService orderService;

    @GetMapping("/account")
    public String getAccountPage(@AuthenticationPrincipal UserDetailsImpl user, Model model){
        model.addAttribute("user", user.getUser());
        model.addAttribute("orders", orderService.readOrders(user.getUser()));
        return "account";
    }
}
