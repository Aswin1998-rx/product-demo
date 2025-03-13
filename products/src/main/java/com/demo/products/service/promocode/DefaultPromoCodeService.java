package com.demo.products.service.promocode;

import com.demo.products.model.promocode.PromoCode;
import com.demo.products.repository.PromoCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultPromoCodeService implements PromoCodeService {
    private final PromoCodeRepository repository;

    @Override
    public PromoCode getPromoCodeByCode(String code) {
        Optional<PromoCode> promoCode;

        try {
            promoCode = repository.findByCode(code);
        }catch (Exception e){
            throw new RuntimeException("failed to fetch promo code");
        }
        return promoCode.orElseThrow(() -> new RuntimeException("promo code not found"));
    }
}
