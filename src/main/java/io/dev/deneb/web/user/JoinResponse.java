package io.dev.deneb.web.user;

import java.time.LocalDateTime;

public record JoinResponse(
        Long id,
        String name,
        LocalDateTime createdAt) {
}
