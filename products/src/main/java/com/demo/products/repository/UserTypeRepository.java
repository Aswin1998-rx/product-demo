package com.demo.products.repository;

import com.demo.products.model.UserType;
import com.demo.products.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType,String> {
    Optional<UserType> findByType(String type);
}
