package io.github.douglasliebl.mscard.application;

import io.github.douglasliebl.mscard.application.representation.CardSaveRequest;
import io.github.douglasliebl.mscard.application.representation.CardsByClientRequest;
import io.github.douglasliebl.mscard.domain.Card;
import io.github.douglasliebl.mscard.domain.ClientCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity saveCard(@RequestBody CardSaveRequest request) {
        Card card = request.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getLessThanEqual(@RequestParam("income") Long income) {
        List<Card> list = cardService.getCardLowerThanOrEquals(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientRequest>> getCardsByUser(@RequestParam("cpf") String cpf) {
        List<ClientCard> clientCards = clientCardService.listCardsByCpf(cpf);
        List<CardsByClientRequest> resultList = clientCards.stream()
                .map(CardsByClientRequest::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
