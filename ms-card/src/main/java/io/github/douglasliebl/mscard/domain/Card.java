package io.github.douglasliebl.mscard.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    @Column
    private BigDecimal income;
    @Column
    private BigDecimal cardLimit;

    public Card(String name, CardFlag flag, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.cardLimit = limit;
    }
}
