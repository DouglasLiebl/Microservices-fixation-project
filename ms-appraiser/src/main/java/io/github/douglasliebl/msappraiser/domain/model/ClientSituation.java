package io.github.douglasliebl.msappraiser.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientSituation {
    private ClientData clientData;
    private List<ClientCards> clientCards;

}
