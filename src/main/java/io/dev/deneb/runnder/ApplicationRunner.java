package io.dev.deneb.runnder;

import io.dev.deneb.entity.Post;
import io.dev.deneb.entity.User;
import io.dev.deneb.repo.PostRepository;
import io.dev.deneb.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = userRepository.save(User.newUser("deneb"));

        List<Post> posts = List.of(
                Post.newPost("title1", "content1", user),
                Post.newPost("title2", "content2", user),
                Post.newPost("title3", "content3", user)
        );

        postRepository.saveAll(posts);
    }

}
