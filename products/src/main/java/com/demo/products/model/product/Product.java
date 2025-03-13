package com.demo.products.model.product;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private String id;
    @Column()
    private String name;
    @Column()
    private String description;
    @Column()
    private BigDecimal basePrice;
    @Column()
    private Long availableQuantity;
    @Column()
    private String category;

}
