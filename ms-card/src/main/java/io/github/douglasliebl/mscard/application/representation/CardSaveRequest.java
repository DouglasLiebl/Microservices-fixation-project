package io.github.douglasliebl.mscard.application.representation;

import io.github.douglasliebl.mscard.domain.Card;
import io.github.douglasliebl.mscard.domain.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {
    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal cardLimit;

    public Card toModel(){
        return new Card(name, flag, income, cardLimit);
    }
}
