package io.github.douglasliebl.msclient.infra.repository;

import io.github.douglasliebl.msclient.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositório padrão para o Objeto cliente;
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);
}
