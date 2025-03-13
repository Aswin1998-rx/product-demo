package com.demo.products.repository;

import com.demo.products.model.product.Product;
import com.demo.products.model.quantitydiscounts.QuantityDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityDiscountRepository extends JpaRepository<QuantityDiscount,Long> {
}
