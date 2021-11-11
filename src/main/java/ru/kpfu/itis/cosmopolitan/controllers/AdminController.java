package ru.kpfu.itis.cosmopolitan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.cosmopolitan.dto.ProductDto;
import ru.kpfu.itis.cosmopolitan.dto.ProductForm;
import ru.kpfu.itis.cosmopolitan.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @GetMapping("/addProduct")
    public String getAddProductPage(){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid ProductForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("validation", bindingResult);
            return "addProduct";
        }
        productService.create(form);
        return "redirect:/admin/products";
    }

    @GetMapping("/products")
    public String getProductsPage(Model model){
        List<ProductDto> list = productService.getAllProducts();
        if(list != null){
            model.addAttribute("products", list);
            model.addAttribute("sold", productService.getCountProductsSold());
        }
        return "products";
    }
}