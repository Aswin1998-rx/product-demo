package com.demo.products.controller;

import com.demo.products.dto.PriceCalculationRequest;
import com.demo.products.dto.PriceCalculationResponse;
import com.demo.products.service.pricecalcculation.PriceCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class PriceCalculationController {

    private final PriceCalculationService priceCalculationService;
    @PostMapping("/price-calculation")
    ResponseEntity<PriceCalculationResponse> calculatePrice(PriceCalculationRequest request) {
   var response =  priceCalculationService.calculatePrice(request);

    return ResponseEntity.ok()
            .body(response);

    }
}
