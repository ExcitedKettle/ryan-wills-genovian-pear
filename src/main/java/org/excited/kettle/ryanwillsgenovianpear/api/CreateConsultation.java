package org.excited.kettle.ryanwillsgenovianpear.api;

import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationRequest;
import org.excited.kettle.ryanwillsgenovianpear.model.CreationResponse;

public interface CreateConsultation {

    CreationResponse requestConsultation(final ConsultationRequest consultationRequest);

}
