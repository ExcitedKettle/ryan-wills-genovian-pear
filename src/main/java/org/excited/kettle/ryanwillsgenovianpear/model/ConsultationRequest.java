package org.excited.kettle.ryanwillsgenovianpear.model;

import java.util.List;

public record ConsultationRequest(
        String questionnaireName,
        List<QuestionnaireAnswer> answers) {
}
