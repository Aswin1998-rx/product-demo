package com.demo.products.service.pricecalcculation;

import com.demo.products.dto.PriceCalculationRequest;
import com.demo.products.dto.PriceCalculationResponse;

public interface PriceCalculationService {

    PriceCalculationResponse calculatePrice(PriceCalculationRequest request);
}
