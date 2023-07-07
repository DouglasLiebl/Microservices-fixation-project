package io.github.douglasliebl.mscard.infra.repository.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.douglasliebl.mscard.domain.Card;
import io.github.douglasliebl.mscard.domain.CardIssuanceRequestData;
import io.github.douglasliebl.mscard.domain.ClientCard;
import io.github.douglasliebl.mscard.infra.repository.CardRepository;
import io.github.douglasliebl.mscard.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receiveIssueRequest(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            CardIssuanceRequestData data = mapper.readValue(payload, CardIssuanceRequestData.class);
            Card card = cardRepository.findById(data.getCardId()).orElseThrow();
            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(data.getCpf());
            clientCard.setCardLimit(data.getApprovedLimit());

            clientCardRepository.save(clientCard);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
