package io.github.douglasliebl.msclient.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Vem do lombok, serve para disponibilizar getters e setters
@NoArgsConstructor
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
