package ru.kpfu.itis.cosmopolitan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.cosmopolitan.services.ApiService;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/priceConverter/{price}")
    public ResponseEntity<Integer> getAllNotNullCountProducts(@PathVariable("price") int price) {
        return ResponseEntity.ok(apiService.convertToRub(price));
    }
}
