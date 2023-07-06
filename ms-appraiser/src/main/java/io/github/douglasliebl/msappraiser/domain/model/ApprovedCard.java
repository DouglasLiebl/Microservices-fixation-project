package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

import java.math.BigDecimal;

// DTO para um cartão aprovado, no campo limite retorna o limite estimado que será disponibilizado;
@Data
public class ApprovedCard {
    private String card;
    private String flag;
    private BigDecimal cardLimit;
}
