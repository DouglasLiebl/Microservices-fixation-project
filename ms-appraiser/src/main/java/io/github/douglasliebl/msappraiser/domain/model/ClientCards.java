package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

import java.math.BigDecimal;

// DTO para os cartões que o cliente possui;
@Data
public class ClientCards {
    private String name;
    private String flag;
    private BigDecimal cardLimit;
}
