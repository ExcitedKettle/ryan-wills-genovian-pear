package org.excited.kettle.ryanwillsgenovianpear.service;

import lombok.AllArgsConstructor;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaire;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaireLookup;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsultationQuestionnaireLookupService implements ConsultationQuestionnaireLookup {

    @Override
    public ConsultationQuestionnaire getQuestionnaireForProduct(final String product) {
        return null;
    }
}
