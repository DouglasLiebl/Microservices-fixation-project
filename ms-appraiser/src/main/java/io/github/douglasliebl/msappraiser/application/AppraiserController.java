package io.github.douglasliebl.msappraiser.application;

import io.github.douglasliebl.msappraiser.application.ex.CardIssuanceErrorException;
import io.github.douglasliebl.msappraiser.application.ex.ClientDataNotFoundException;
import io.github.douglasliebl.msappraiser.application.ex.MicroservicesCommunicationErrorException;
import io.github.douglasliebl.msappraiser.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Rest Controller para o microservice de análise;
@RestController
@RequestMapping("/appraiser")
@RequiredArgsConstructor
public class AppraiserController {

    private final ClientSituationService clientSituationService;

    @GetMapping
    public String status() {
        return "ok";
    }

    // Recebe o cpf do cliente e retorna a situação do mesmo, dados, cartões que já possui etc..;
    @GetMapping(value = "client-situation", params = "cpf")
    public ResponseEntity customerSituation(@RequestParam ("cpf") String cpf) {
        try {
            ClientSituation clientSituation = clientSituationService.getClientSituation(cpf);
            return ResponseEntity.ok(clientSituation);
        } catch (ClientDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (MicroservicesCommunicationErrorException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    // Envia o cpf e a renda do cliente e retorna quais cartões estão disponíveis para o mesmo;
    @PostMapping
    public ResponseEntity carryOutEvaluation(@RequestBody EvaluationData data) {
        try {
            ReturnClientEvaluation returnClientEvaluation = clientSituationService
                    .carryOutEvaluation(data.getCpf(), data.getIncome());
            return ResponseEntity.ok(returnClientEvaluation);
        } catch (ClientDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (MicroservicesCommunicationErrorException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("card-request")
    public ResponseEntity cardRequest(@RequestBody CardIssueRequestData data) {
        try {
            CardIssuanceProtocol cardIssuanceProtocol = clientSituationService
                    .cardIssuanceRequest(data);
            return ResponseEntity.ok(cardIssuanceProtocol);
        } catch (CardIssuanceErrorException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
