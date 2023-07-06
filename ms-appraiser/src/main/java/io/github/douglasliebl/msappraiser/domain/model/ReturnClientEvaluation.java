package io.github.douglasliebl.msappraiser.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

// DTO para os cartões aprovados após a análise;
@Data
@AllArgsConstructor
public class ReturnClientEvaluation {
    private List<ApprovedCard> approvedCardList;
}
