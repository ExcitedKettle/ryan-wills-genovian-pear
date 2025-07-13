package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.Builder;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestion;

import java.util.List;
import java.util.UUID;

@Builder(setterPrefix = "with")
public record MultipleChoiceQuestion(List<String> options,
                                     String question,
                                     int questionNumber,
                                     UUID questionId) implements ConsultationQuestion {
}
