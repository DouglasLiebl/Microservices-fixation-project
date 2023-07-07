package io.github.douglasliebl.msappraiser.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.douglasliebl.msappraiser.domain.model.CardIssueRequestData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuancePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueCardIssuance;

    public void requestCard(CardIssueRequestData data) throws JsonProcessingException{
        var json = convertIntoJson(data);
        rabbitTemplate.convertAndSend(queueCardIssuance.getName(), json);

    }

    private String convertIntoJson(CardIssueRequestData data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(data);
        return json;
    }

}
