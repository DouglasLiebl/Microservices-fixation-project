package io.github.douglasliebl.mscard.application;

import io.github.douglasliebl.mscard.domain.Card;
import io.github.douglasliebl.mscard.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card){
        return cardRepository.save(card);
    }

    public List<Card> getCardLowerThanOrEquals(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
