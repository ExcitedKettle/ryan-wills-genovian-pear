package org.excited.kettle.ryanwillsgenovianpear.adaptor;

import lombok.AllArgsConstructor;
import org.excited.kettle.ryanwillsgenovianpear.api.LookupConsultation;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaireLookup;
import org.excited.kettle.ryanwillsgenovianpear.api.CreateConsultation;
import org.excited.kettle.ryanwillsgenovianpear.api.Questionnaire;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationRequest;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationResponse;
import org.excited.kettle.ryanwillsgenovianpear.model.CreationResponse;
import org.excited.kettle.ryanwillsgenovianpear.service.ConsultationQuestionnaireStorageService;
import org.excited.kettle.ryanwillsgenovianpear.service.ConsultationQuestionnaireLookupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class ControllerConsultation implements ConsultationQuestionnaireLookup, CreateConsultation, LookupConsultation {

    private ConsultationQuestionnaireLookupService consultationQuestionnaireLookupService;
    private ConsultationQuestionnaireStorageService consultationQuestionnaireStorageService;

    @Override
    @GetMapping(value = "/consultation/questionnaire")
    public Questionnaire getQuestionnaireForProduct(final String product) {
        return consultationQuestionnaireLookupService.getQuestionnaireForProduct(product);
    }

    @Override
    @PostMapping(value = "/consultation")
    public CreationResponse requestConsultation(@RequestBody final ConsultationRequest consultationRequest) {
        return consultationQuestionnaireStorageService.requestConsultation(consultationRequest);
    }

    @Override
    @GetMapping(value = "/consultation")
    public ConsultationResponse getConsultation(final UUID id) {
        return consultationQuestionnaireStorageService.getConsultation(id);
    }
}