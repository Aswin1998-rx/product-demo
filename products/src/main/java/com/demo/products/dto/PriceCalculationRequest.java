package com.demo.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceCalculationRequest {
    private String productId;
    private Long quantity;
    private String promoCode;
    private String userType;

}
