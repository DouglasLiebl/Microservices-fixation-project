package io.github.douglasliebl.msappraiser.application;

import io.github.douglasliebl.msappraiser.domain.model.ClientCards;
import io.github.douglasliebl.msappraiser.domain.model.ClientData;
import io.github.douglasliebl.msappraiser.domain.model.ClientSituation;
import io.github.douglasliebl.msappraiser.infra.clients.CardResourceClient;
import io.github.douglasliebl.msappraiser.infra.clients.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientSituationService {

    private final ClientResourceClient clientResourceClient;
    private final CardResourceClient cardResourceClient;
    public ClientSituation getClientSituation(String cpf) {
        ResponseEntity<ClientData> clientDataResponse = clientResourceClient.clientData(cpf);
        ResponseEntity<List<ClientCards>> cardDataResponse = cardResourceClient.getCardsByCpf(cpf);
        return ClientSituation
                .builder()
                .clientData(clientDataResponse.getBody())
                .clientCards(cardDataResponse.getBody())
                .build();
    }
}
