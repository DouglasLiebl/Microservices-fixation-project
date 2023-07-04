package io.github.douglasliebl.msclient.application.representation;

import io.github.douglasliebl.msclient.domain.Client;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

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
