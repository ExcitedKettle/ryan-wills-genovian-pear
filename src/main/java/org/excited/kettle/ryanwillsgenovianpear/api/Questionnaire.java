package org.excited.kettle.ryanwillsgenovianpear.api;

import org.excited.kettle.ryanwillsgenovianpear.model.MultipleChoiceQuestion;
import org.excited.kettle.ryanwillsgenovianpear.model.OpenQuestion;

import java.util.List;

public interface Questionnaire {
    List<MultipleChoiceQuestion> multipleChoiceQuestions();
    List<OpenQuestion> openQuestions();
    String name();
}
