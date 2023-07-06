package io.github.douglasliebl.mscard.application.representation;

import io.github.douglasliebl.mscard.domain.CardFlag;
import io.github.douglasliebl.mscard.domain.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// DTO para Cliente-Cartão;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsByClientRequest {
    private String name;
    private CardFlag flag;
    private BigDecimal cardLimit;

    public static CardsByClientRequest fromModel(ClientCard model) {
        return new CardsByClientRequest(
                model.getCpf(),
                model.getCard().getFlag(),
                model.getCardLimit());
    }
}
