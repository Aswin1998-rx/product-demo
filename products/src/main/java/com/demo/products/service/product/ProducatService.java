package com.demo.products.service.product;

import com.demo.products.model.product.Product;
import com.demo.products.model.promocode.PromoCode;

public interface ProducatService {

    Product getProductById(String code);
}
