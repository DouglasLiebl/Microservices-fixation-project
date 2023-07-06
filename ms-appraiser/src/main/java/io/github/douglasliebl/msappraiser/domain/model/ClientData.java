package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

// DTO para o cliente;
@Data
public class ClientData {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
}
