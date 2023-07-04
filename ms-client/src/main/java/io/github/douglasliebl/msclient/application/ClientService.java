package io.github.douglasliebl.msclient.application;

import io.github.douglasliebl.msclient.domain.Client;
import io.github.douglasliebl.msclient.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor // Cria o construtor para o clientRepository
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getByCPF(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}
