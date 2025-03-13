package com.demo.products.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceCalculationResponse {
    private String productId;
    private BigDecimal originalPrice;
    private BigDecimal  finalPrice;
    private List<DiscountResponse> appliedDiscounts;
    private BigDecimal totalSavings;

}
