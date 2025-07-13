package org.excited.kettle.ryanwillsgenovianpear.service;

import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationQuestionnaire;
import org.excited.kettle.ryanwillsgenovianpear.model.MultipleChoiceQuestion;
import org.excited.kettle.ryanwillsgenovianpear.model.OpenQuestion;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ConsultationQuestionnaireLookupServiceTest {

    @InjectMocks
    private ConsultationQuestionnaireLookupService consultationQuestionnaireLookupService;

    @Nested
    class GetQuestionnaireForProduct {

        @Test
        void canGetQuestionnaire() {
            final OpenQuestion openQuestion = OpenQuestion
                    .builder()
                    .withQuestion("This is an open Question")
                    .withQuestionNumber(0)
                    .build();

            final MultipleChoiceQuestion multipleChoiceQuestion = MultipleChoiceQuestion
                    .builder()
                    .withOptions(List.of("option1", "option2", "option3"))
                    .withQuestionNumber(1)
                    .withQuestion("This is a multiple choice question")
                    .build();

            final ConsultationQuestionnaire expected = ConsultationQuestionnaire
                    .builder()
                    .withOpenQuestions(List.of(openQuestion))
                    .withMultipleChoiceQuestions(List.of(multipleChoiceQuestion))
                    .build();

            assertThat(consultationQuestionnaireLookupService.getQuestionnaireForProduct("product")).isEqualTo(expected);
        }
    }

}