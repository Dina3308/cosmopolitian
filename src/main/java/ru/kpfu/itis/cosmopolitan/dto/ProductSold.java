package ru.kpfu.itis.cosmopolitan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductSold {
    Long id;
    int sum;

    public ProductSold(Long id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }
}
