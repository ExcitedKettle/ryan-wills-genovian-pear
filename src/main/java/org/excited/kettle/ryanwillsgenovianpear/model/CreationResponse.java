package org.excited.kettle.ryanwillsgenovianpear.model;

import lombok.Builder;
import org.excited.kettle.ryanwillsgenovianpear.api.ResponseWithId;

import java.util.UUID;

@Builder(setterPrefix = "with")
public record CreationResponse(UUID id, String message) implements ResponseWithId {

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
