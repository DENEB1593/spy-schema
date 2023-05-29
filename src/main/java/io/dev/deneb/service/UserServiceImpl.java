package io.dev.deneb.service;

import io.dev.deneb.entity.User;
import io.dev.deneb.repo.UserRepository;
import io.dev.deneb.web.user.JoinRequest;
import io.dev.deneb.web.user.JoinResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public JoinResponse join(JoinRequest request) {
        final var user = userRepository.save(
                User.newUser(request.name())
        );

        return new JoinResponse(user.getId(), user.getName());
    }
}
