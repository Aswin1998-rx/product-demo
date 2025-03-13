package com.demo.products.repository;

import com.demo.products.model.product.Product;
import com.demo.products.model.promocode.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode,String> {
    Optional<PromoCode> findByCode(String code);
}
