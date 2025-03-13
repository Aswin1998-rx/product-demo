package com.demo.products.dto;

import com.demo.products.model.DiscountType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountResponse {
    private DiscountType discountType;
    private BigDecimal discountPercentage;
}
