package io.dev.deneb.service;

import io.dev.deneb.web.user.JoinRequest;
import io.dev.deneb.web.user.JoinResponse;

public interface UserService {

    JoinResponse join(JoinRequest request);
}
