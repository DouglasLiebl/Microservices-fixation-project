package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

import java.math.BigDecimal;

// DTO para cartão;
@Data
public class Card {
    private Long id;
    private String name;
    private String flag;
    private BigDecimal cardLimit;
}
