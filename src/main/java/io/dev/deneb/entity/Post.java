package io.dev.deneb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "post")
@Setter @Getter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Post() { }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public Post newPost(String title, String content) {
        var post = new Post(title, content);
        post.setCreatedAt(LocalDateTime.now(ZoneId.systemDefault()));
        return post;
    }


}
