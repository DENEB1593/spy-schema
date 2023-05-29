package io.dev.deneb.web;

import io.dev.deneb.entity.Post;
import io.dev.deneb.service.UserService;
import io.dev.deneb.web.user.JoinRequest;
import io.dev.deneb.web.user.JoinResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/join")
    public JoinResponse join(@RequestBody JoinRequest request) {
        return userService.join(request);
    }

    @GetMapping("/{id}")
    public List<Post> findPosts(@PathVariable Long id) {
        List<Post> posts = userService.findPosts(id);
        return posts;
    }


}
