package org.excited.kettle.ryanwillsgenovianpear.api;

import org.excited.kettle.ryanwillsgenovianpear.model.ConsultationResponse;

import java.util.UUID;

public interface LookupConsultation {
    ConsultationResponse getConsultation(final UUID id);
}
