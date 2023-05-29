package io.dev.deneb.web.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record JoinResponse(Long id, String name) {
}
