package io.github.douglasliebl.msclient.application;

import io.github.douglasliebl.msclient.application.representation.ClientSaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
// Rest Controller de clientes, onde todos os endpoints são criados e implementados;
@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Slf4j
public class ClientResource {

    private final ClientService clientService;

    @GetMapping
    public String status(){
        log.info("Obtendo o status do microservice de clientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request) {
        var client = request.toModel();
        clientService.save(client);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity customerData(@RequestParam("cpf") String cpf) {
        var client = clientService.getByCPF(cpf);
        if (client.isEmpty()) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }


}
