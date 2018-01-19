package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    //

    private List<Post> posts = new ArrayList<>();

    public PostService() {
        createDummyList();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public void createDummyList() {
        save(new Post(1L, "First Post", "First Body"));
        save(new Post(2L, "Second Post", "Second Body"));
        save(new Post(3L, "Third Post", "Third Body"));
    }
}
