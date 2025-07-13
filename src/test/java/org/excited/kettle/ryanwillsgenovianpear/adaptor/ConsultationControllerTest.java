package org.excited.kettle.ryanwillsgenovianpear.adaptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.excited.kettle.ryanwillsgenovianpear.model.MultipleChoiceQuestion;
import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationQuestionnaire;
import org.excited.kettle.ryanwillsgenovianpear.service.ConsultationQuestionnaireLookupService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ControllerConsultation.class)
class ConsultationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    ConsultationQuestionnaireLookupService consultationQuestionnaireLookupService;

    @Nested
    class GetConsultation {

        @Test
        void canLookupAConsultation() throws Exception {
            final String product = "gennovianPear";

            final MultipleChoiceQuestion question = MultipleChoiceQuestion
                    .builder()
                    .withOptions(List.of("option1", "option2", "option3"))
                    .withQuestion("which option?")
                    .build();

            final ConsultationQuestionnaire questionnaire = new ConsultationQuestionnaire(List.of(question), List.of(), "pear questionnaire");

            given(consultationQuestionnaireLookupService.getQuestionnaireForProduct(product)).willReturn(questionnaire);

            final String response = mockMvc.perform(MockMvcRequestBuilders.get("/consultation/questionnaire?product=" + product)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            final ConsultationQuestionnaire actual = objectMapper.readValue(response, ConsultationQuestionnaire.class);
            assertThat(actual).isEqualTo(questionnaire);
        }
    }
}