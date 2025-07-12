package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.excited.kettle.ryanwillsgenovianpear.api.ConsultationQuestion;

import java.util.List;

@AllArgsConstructor
@Builder(setterPrefix = "with")
@Getter
@ToString
@EqualsAndHashCode
public class MultipleChoiceQuestion implements ConsultationQuestion {

    private List<String> options;
    private String question;
}
