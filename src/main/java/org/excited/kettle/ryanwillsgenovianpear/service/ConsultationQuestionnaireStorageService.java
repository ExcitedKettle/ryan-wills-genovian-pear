package org.excited.kettle.ryanwillsgenovianpear.service;

import org.excited.kettle.ryanwillsgenovianpear.api.CreateConsultation;
import org.excited.kettle.ryanwillsgenovianpear.api.LookupConsultation;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationRequest;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationResponse;
import org.excited.kettle.ryanwillsgenovianpear.model.CreationResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
public class ConsultationQuestionnaireStorageService implements CreateConsultation, LookupConsultation {

    @Override
    public CreationResponse requestConsultation(final ConsultationRequest consultationRequest) {

        // This would be a good moment to validate that the answers to the questionnaire are answered in a satysfying manner and then store it.

        return CreationResponse.builder()
                .withMessage("Request successfully created")
                .withId(UUID.randomUUID())
                .build();
    }


    @Override
    public ConsultationResponse getConsultation(final UUID id) {
              return ConsultationResponse
                .builder()
                .withMessage("Prescription accepted")
                .build();
    }
}
