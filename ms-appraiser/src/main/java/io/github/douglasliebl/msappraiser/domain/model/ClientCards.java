package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientCards {
    private String name;
    private String flag;
    private BigDecimal cardLimit;
}
