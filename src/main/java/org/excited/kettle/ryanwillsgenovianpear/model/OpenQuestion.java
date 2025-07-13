package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.Builder;
import lombok.Getter;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestion;

import java.util.UUID;

@Builder(setterPrefix = "with")
public record OpenQuestion(String question, int questionNumber, UUID questionId) implements ConsultationQuestion {
}
