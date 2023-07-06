package io.github.douglasliebl.mscard.infra.repository;

import io.github.douglasliebl.mscard.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

// Repositório padrão para o cartão;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByIncomeLessThanEqual(BigDecimal income);
}
