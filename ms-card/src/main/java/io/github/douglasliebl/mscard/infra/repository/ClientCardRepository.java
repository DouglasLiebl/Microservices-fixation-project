package io.github.douglasliebl.mscard.infra.repository;

import io.github.douglasliebl.mscard.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositório padrão para o Cliente-Cartão;
@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    List<ClientCard> findByCpf(String cpf);
}
