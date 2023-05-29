package io.dev.deneb.service;

import io.dev.deneb.entity.Post;
import io.dev.deneb.web.user.JoinRequest;
import io.dev.deneb.web.user.JoinResponse;

import java.util.List;

public interface UserService {

    JoinResponse join(JoinRequest request);

    List<Post> findPosts(Long id);
}
