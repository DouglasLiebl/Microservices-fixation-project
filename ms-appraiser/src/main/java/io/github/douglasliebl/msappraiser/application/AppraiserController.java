package io.github.douglasliebl.msappraiser.application;

import io.github.douglasliebl.msappraiser.domain.model.ClientSituation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ClientSituation> customerSituation(@RequestParam ("cpf") String cpf) {
        ClientSituation clientSituation = clientSituationService.getClientSituation(cpf);
        return ResponseEntity.ok(clientSituation);
    }
}
