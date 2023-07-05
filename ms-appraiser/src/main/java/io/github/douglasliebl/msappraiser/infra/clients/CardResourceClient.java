package io.github.douglasliebl.msappraiser.infra.clients;

import io.github.douglasliebl.msappraiser.domain.model.Card;
import io.github.douglasliebl.msappraiser.domain.model.ClientCards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ms-card", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCards>> getCardsByCpf(@RequestParam("cpf") String cpf);

    @GetMapping(params = "income")
    ResponseEntity<List<Card>> getLessThanEqual(@RequestParam("income") Long income);
}
