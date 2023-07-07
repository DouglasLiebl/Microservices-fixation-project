package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardIssueRequestData {
    private Long cardId;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;
}
