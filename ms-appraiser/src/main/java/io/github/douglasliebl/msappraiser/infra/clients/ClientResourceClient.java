package io.github.douglasliebl.msappraiser.infra.clients;

import io.github.douglasliebl.msappraiser.domain.model.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-client", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<ClientData> clientData(@RequestParam("cpf") String cpf);

}
