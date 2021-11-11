package ru.kpfu.itis.cosmopolitan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.cosmopolitan.dto.BasketDto;
import ru.kpfu.itis.cosmopolitan.security.details.UserDetailsImpl;
import ru.kpfu.itis.cosmopolitan.services.BasketService;

@RestController
@RequestMapping("api/baskets")
public class BasketsController {

    @Autowired
    BasketService basketService;

    @DeleteMapping("/{basket-id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("basket-id") Long basketId) {
        basketService.delete(basketId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{basket-id}")
    public ResponseEntity<BasketDto> updateProduct(@PathVariable("basket-id") Long basketId, @RequestBody int count) {
        return ResponseEntity.ok(basketService.update(basketId, count));
    }

    @PostMapping("/create/{product-id}")
    public ResponseEntity<?> addBasket(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("product-id") Long productId, @RequestBody int count) {
        if(user != null){
            basketService.create(user.getUser(), count, productId);
            return ResponseEntity.status(200).build();
        }
        else{
            return ResponseEntity.status(404).build();
        }
    }

}
