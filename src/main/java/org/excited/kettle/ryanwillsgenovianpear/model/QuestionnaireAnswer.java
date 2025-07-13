package org.excited.kettle.ryanwillsgenovianpear.model;

import org.excited.kettle.ryanwillsgenovianpear.api.Answer;

import java.util.UUID;

public record QuestionnaireAnswer(String answer, UUID questionId) implements Answer {

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public UUID getQuestionId() {
        return questionId;
    }
}
