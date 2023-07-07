package io.github.douglasliebl.mscard.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// Entidade que serve para relacionar os cartões de cada cliente;
@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_client_card")
public class ClientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;
    @Column
    private BigDecimal cardLimit;
}
