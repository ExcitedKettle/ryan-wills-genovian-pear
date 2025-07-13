package org.excited.kettle.ryanwillsgenovianpear.service;

import lombok.AllArgsConstructor;
import org.excited.kettle.ryanwillsgenovianpear.api.Questionnaire;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaireLookup;
import org.excited.kettle.ryanwillsgenovianpear.api.Response;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationQuestionnaire;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationRequest;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationResponse;
import org.excited.kettle.ryanwillsgenovianpear.model.CreationResponse;
import org.excited.kettle.ryanwillsgenovianpear.model.MultipleChoiceQuestion;
import org.excited.kettle.ryanwillsgenovianpear.model.OpenQuestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ConsultationQuestionnaireLookupService implements ConsultationQuestionnaireLookup {

    @Override
    public Questionnaire getQuestionnaireForProduct(final String product) {

        final OpenQuestion openQuestion = OpenQuestion
                .builder()
                .withQuestion("This is an open Question")
                .withQuestionNumber(0)
                .withQuestionId(UUID.randomUUID())
                .build();

        final MultipleChoiceQuestion multipleChoiceQuestion = MultipleChoiceQuestion
                .builder()
                .withOptions(List.of("option1", "option2", "option3"))
                .withQuestionNumber(1)
                .withQuestion("This is a multiple choice question")
                .withQuestionId(UUID.randomUUID())
                .build();

        return ConsultationQuestionnaire
                .builder()
                .withOpenQuestions(List.of(openQuestion))
                .withMultipleChoiceQuestions(List.of(multipleChoiceQuestion))
                .withName("Pear Questionnaire")
                .build();
    }
}
