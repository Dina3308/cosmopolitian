package ru.kpfu.itis.cosmopolitan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.cosmopolitan.dto.UserSignUpForm;
import ru.kpfu.itis.cosmopolitan.services.SignUpService;
import ru.kpfu.itis.cosmopolitan.utils.exceptions.AuthException;
import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid UserSignUpForm form, BindingResult bindingResult, Model model){
        try {
            if(bindingResult.hasErrors()){
                model.addAttribute("validation", bindingResult);
                return "signUp";
            }
            signUpService.signUp(form);
            return "redirect:/account";
        }
        catch (AuthException ex){
            model.addAttribute("error", ex.getMessage());
            return "signUp";
        }
    }

}