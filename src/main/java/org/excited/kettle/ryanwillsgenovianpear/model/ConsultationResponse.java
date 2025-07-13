package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.Builder;
import org.excited.kettle.ryanwillsgenovianpear.api.Response;

@Builder(setterPrefix = "with")
public record ConsultationResponse(String message) implements Response {

    @Override
    public String getMessage() {
        return message;
    }
}
