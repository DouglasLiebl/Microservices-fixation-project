package io.github.douglasliebl.msappraiser.application;

import feign.FeignException;
import io.github.douglasliebl.msappraiser.application.ex.ClientDataNotFoundException;
import io.github.douglasliebl.msappraiser.application.ex.MicroservicesCommunicationErrorException;
import io.github.douglasliebl.msappraiser.domain.model.*;
import io.github.douglasliebl.msappraiser.infra.clients.CardResourceClient;
import io.github.douglasliebl.msappraiser.infra.clients.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientSituationService {

    private final ClientResourceClient clientResourceClient;
    private final CardResourceClient cardResourceClient;
    public ClientSituation getClientSituation(String cpf) throws ClientDataNotFoundException, MicroservicesCommunicationErrorException {
        try {
            ResponseEntity<ClientData> clientDataResponse = clientResourceClient.clientData(cpf);
            ResponseEntity<List<ClientCards>> cardDataResponse = cardResourceClient.getCardsByCpf(cpf);
            return ClientSituation
                    .builder()
                    .clientData(clientDataResponse.getBody())
                    .clientCards(cardDataResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
             int status = e.status();
             if(HttpStatus.NOT_FOUND.value() == status) {
                throw new ClientDataNotFoundException();
             }
             throw new MicroservicesCommunicationErrorException(e.getMessage(), status);
        }
    }

    public ReturnClientEvaluation carryOutEvaluation(String cpf, Long income)
            throws ClientDataNotFoundException, MicroservicesCommunicationErrorException {
        try {
            ResponseEntity<ClientData> clientDataResponse = clientResourceClient.clientData(cpf);
            ResponseEntity<List<Card>> cardDataResponse = cardResourceClient.getLessThanEqual(income);

            List<Card> cards = cardDataResponse.getBody();
            var approvedCards = cards.stream().map(card -> {

                ClientData clientData = clientDataResponse.getBody();

                BigDecimal cardLimit = card.getCardLimit();
                BigDecimal ageBigDecimal = BigDecimal.valueOf(clientData.getAge());
                var factor = ageBigDecimal.divide(BigDecimal.TEN);
                BigDecimal approvedLimit = factor.multiply(cardLimit);

                ApprovedCard approved = new ApprovedCard();
                approved.setCard(card.getName());
                approved.setFlag(card.getFlag());
                approved.setCardLimit(approvedLimit);

                return approved;
            }).collect(Collectors.toList());

            return new ReturnClientEvaluation(approvedCards);

        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status) {
                throw new ClientDataNotFoundException();
            }
            throw new MicroservicesCommunicationErrorException(e.getMessage(), status);
        }
    }
}
