package ru.kpfu.itis.cosmopolitan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.cosmopolitan.models.Basket;
import ru.kpfu.itis.cosmopolitan.models.BasketToProduct;
import ru.kpfu.itis.cosmopolitan.models.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDto {
    private Long id;
    private int count;
    private Long productId;
    private String productName;
    private String category;
    private int productPrice;
    private int productCount;
    private String productImg;
    private String description;

    public static BasketDto from(BasketToProduct basket) {
        if(basket != null){
            return BasketDto.builder()
                    .id(basket.getId())
                    .count(basket.getCount())
                    .productId(basket.getProduct().getId())
                    .category(basket.getProduct().getCategory())
                    .description(basket.getProduct().getDescription())
                    .productCount(basket.getProduct().getProductCount())
                    .productImg(basket.getProduct().getProductImg())
                    .productName(basket.getProduct().getProductName())
                    .productPrice(basket.getProduct().getProductPrice())
                    .build();
        }
        else {
            return null;
        }
    }

    public static List<BasketDto> from(List<BasketToProduct> baskets) {
        return baskets.stream()
                .map(BasketDto::from)
                .collect(Collectors.toList());
    }
}
