package ru.kpfu.itis.cosmopolitan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.cosmopolitan.dto.ProductDto;
import ru.kpfu.itis.cosmopolitan.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/notNullCountProducts")
    public ResponseEntity<List<ProductDto>> getAllNotNullCountProducts() {
        return ResponseEntity.ok(productService.getAllNotNullCountProducts());
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("product-id") Long productId) {
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("product-id") Long productId, @RequestBody  int count) {
        return ResponseEntity.ok(productService.update(productId, count));
    }

}
