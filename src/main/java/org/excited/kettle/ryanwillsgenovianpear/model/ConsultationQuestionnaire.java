package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.Builder;
import org.excited.kettle.ryanwillsgenovianpear.api.Questionnaire;

import java.util.List;

@Builder(setterPrefix = "with")
public record ConsultationQuestionnaire(List<MultipleChoiceQuestion> multipleChoiceQuestions,
                                        List<OpenQuestion> openQuestions,
                                        String name) implements Questionnaire {
}
