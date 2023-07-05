package io.github.douglasliebl.msappraiser.application;

import io.github.douglasliebl.msappraiser.application.ex.ClientDataNotFoundException;
import io.github.douglasliebl.msappraiser.application.ex.MicroservicesCommunicationErrorException;
import io.github.douglasliebl.msappraiser.domain.model.ClientSituation;
import io.github.douglasliebl.msappraiser.domain.model.EvaluationData;
import io.github.douglasliebl.msappraiser.domain.model.ReturnClientEvaluation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appraiser")
@RequiredArgsConstructor
public class AppraiserController {

    private final ClientSituationService clientSituationService;

    @GetMapping
    public String status() {
        return "ok";
    }

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
}
