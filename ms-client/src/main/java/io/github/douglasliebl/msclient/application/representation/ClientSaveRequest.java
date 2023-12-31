package io.github.douglasliebl.msclient.application.representation;

import io.github.douglasliebl.msclient.domain.Client;
import lombok.Data;

// DTO do cliente
@Data
public class ClientSaveRequest {
    private String cpf;
    private String firstName;
    private String lastName;
    private Integer age;

    public Client toModel() {
        return new Client(cpf, firstName, lastName, age);
    }

}
