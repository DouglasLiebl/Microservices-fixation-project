package io.github.douglasliebl.msclient.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entidade cliente, diz quais os campos um cliente deve possuir além dos tipos de cada campo;
@Entity
@Data // Vem do lombok, serve para disponibilizar getters e setters;
@NoArgsConstructor // Fornece um construtor sem argumentos;
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer age;

    public Client (String cpf, String firstName, String lastName, Integer age) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
