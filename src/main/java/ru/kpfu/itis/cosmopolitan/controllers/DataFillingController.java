package ru.kpfu.itis.cosmopolitan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.cosmopolitan.dto.DataFillingForm;
import ru.kpfu.itis.cosmopolitan.security.details.UserDetailsImpl;
import ru.kpfu.itis.cosmopolitan.services.OrderService;

import javax.validation.Valid;

@Controller
public class DataFillingController {

    @Autowired
    OrderService orderService;

    @GetMapping("/dataFilling")
    public String getDataFillingPage(){
        return "dataFilling";
    }

    @PostMapping("/order")
    public String order(@Valid DataFillingForm form, BindingResult bindingResult, Model model, @AuthenticationPrincipal UserDetailsImpl user){
        if(bindingResult.hasErrors()){
            model.addAttribute("validation", bindingResult);
            return "dataFilling";
        }
        orderService.createOrder(user.getUser(), form);
        return "redirect:/account";
    }
}
