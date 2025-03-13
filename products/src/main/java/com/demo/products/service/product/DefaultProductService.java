package com.demo.products.service.product;

import com.demo.products.model.product.Product;
import com.demo.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultProductService implements ProducatService {

    private final ProductRepository repository;

    @Override
    public Product getProductById(String code) {
        Optional<Product> product;
        try {
            product = repository.findById(code);

        } catch (Exception e) {
            throw new RuntimeException("Product not found");
        }
        return product.orElseThrow(() -> new RuntimeException("product not found"));

    }
}
