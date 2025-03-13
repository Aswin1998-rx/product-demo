package com.demo.products.service.pricecalcculation;

import com.demo.products.dto.DiscountResponse;
import com.demo.products.dto.PriceCalculationRequest;
import com.demo.products.dto.PriceCalculationResponse;
import com.demo.products.model.DiscountType;
import com.demo.products.service.product.ProducatService;
import com.demo.products.service.promocode.PromoCodeService;
import com.demo.products.service.usertype.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultPriceCalculationService implements PriceCalculationService {

    private final ProducatService producatService;
    private final PromoCodeService promoCodeService;
    private final UserTypeService userTypeService;
    @Override
    public PriceCalculationResponse calculatePrice(PriceCalculationRequest request) {

        var usertype = userTypeService.getUserTypeByType(request.getUserType());
        var product = producatService.getProductById(request.getProductId());
        var promoCode = promoCodeService.getPromoCodeByCode(request.getPromoCode());
        List<DiscountResponse> discountResponses = new ArrayList<>();
        BigDecimal discount = BigDecimal.ZERO;
        if (promoCode.getActive()){
            discount = discount.add(product.getBasePrice().multiply(promoCode.getDiscountPercentage()));
            discountResponses.add(DiscountResponse.builder()
                    .discountPercentage(promoCode.getDiscountPercentage())
                    .discountType(DiscountType.PROMO_CODE)
                    .build());
        }

        if (usertype.getType().equals("PREMIUM_USER")) {
            discount = discount.add(product.getBasePrice().multiply(usertype.getDiscountPercentage()));
            discountResponses.add(DiscountResponse.builder()
                    .discountPercentage(usertype.getDiscountPercentage())
                    .discountType(DiscountType.PREMIUM_USER)
                    .build());
        }


        return PriceCalculationResponse.builder()
                .productId(product.getId())
                .originalPrice(product.getBasePrice())
                .finalPrice(product.getBasePrice().subtract(discount))
                .appliedDiscounts(discountResponses)
                .totalSavings(discount)
                .build();
    }
}
