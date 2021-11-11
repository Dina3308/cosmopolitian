package ru.kpfu.itis.cosmopolitan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.cosmopolitan.models.Order;
import ru.kpfu.itis.cosmopolitan.models.OrderToProduct;
import ru.kpfu.itis.cosmopolitan.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String region;
    private String city;
    private String street;
    private int totalPrice;
    private List<ProductDto> products;

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }

    public static OrderDto from(Order order) {
        List<OrderToProduct> orderToProducts = order.getOrderToProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        int totalPrice = 0;

        for(OrderToProduct p : orderToProducts){
            totalPrice += p.getPrice() * p.getCount();
            productDtos.add(ProductDto.from(p.getProduct(), p.getCount(), p.getPrice()));
        }

        return OrderDto.builder()
                .id(order.getId())
                .city(order.getCity())
                .email(order.getEmail())
                .name(order.getName())
                .phoneNumber(order.getPhoneNumber())
                .region(order.getRegion())
                .surname(order.getSurname())
                .street(order.getStreet())
                .totalPrice(totalPrice)
                .products(productDtos)
                .build();
    }
}
