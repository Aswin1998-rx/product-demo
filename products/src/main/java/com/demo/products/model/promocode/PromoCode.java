package com.demo.products.model.promocode;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promo_codes")
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private String code;
    @Column()
    private BigDecimal discountPercentage;
    @Column()
    private Boolean active;
    @Column()
    private LocalDate validUntil;

}
