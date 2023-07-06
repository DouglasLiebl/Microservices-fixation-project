package io.github.douglasliebl.mscard.application;

import io.github.douglasliebl.mscard.domain.ClientCard;
import io.github.douglasliebl.mscard.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Serviços para a relação Cliente-Cartão
@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository cardRepository;

    public List<ClientCard> listCardsByCpf(String cpf) {
        return cardRepository.findByCpf(cpf);
    }
}
