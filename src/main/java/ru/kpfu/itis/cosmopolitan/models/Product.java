package ru.kpfu.itis.cosmopolitan.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String category;
    private int productPrice;
    private int productCount;
    private String productImg;
    private String description;

    @OneToMany(mappedBy = "product")
    private List<BasketToProduct> basketToProducts;

    @OneToMany(mappedBy = "product")
    private List<OrderToProduct> orderToProducts;
}
