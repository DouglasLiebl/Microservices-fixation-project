package io.github.douglasliebl.msappraiser.domain.model;

import lombok.Data;

// DTO para os dados que serão utilizados para a análise de disponibilidade dos cartões;
@Data
public class EvaluationData {
    private String cpf;
    private Long income;
}
