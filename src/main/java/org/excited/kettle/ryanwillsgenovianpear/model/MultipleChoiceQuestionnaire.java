package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestionnaire;

import java.util.List;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MultipleChoiceQuestionnaire implements ConsultationQuestionnaire {

    private final List<MultipleChoiceQuestion> questions;

}
