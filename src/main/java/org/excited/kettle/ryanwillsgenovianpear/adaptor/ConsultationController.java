package org.excited.kettle.ryanwillsgenovianpear.adaptor;

import lombok.AllArgsConstructor;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaire;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaireLookup;
import org.excited.kettle.ryanwillsgenovianpear.service.ConsultationQuestionnaireLookupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class ConsultationController implements ConsultationQuestionnaireLookup {

    private ConsultationQuestionnaireLookupService consultationQuestionnaireLookupService;

    @Override
    @GetMapping(value = "/consultation/questionnaire", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ConsultationQuestionnaire getQuestionnaireForProduct(final String product) {
        return consultationQuestionnaireLookupService.getQuestionnaireForProduct(product);
    }
}