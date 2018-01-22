package com.codeup.springbootblog.services;

import com.codeup.springbootblog.daos.PostRepository;
import com.codeup.springbootblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postsDao;

//    private List<Post> posts = new ArrayList<>();

    @Autowired
    public PostService(PostRepository postsDao) {
        this.postsDao = postsDao;
//        createDummyList();
    }

    public Iterable<Post> findAll() {
//        return posts;
        return postsDao.findAll();
    }

    public Post findOne(long id) {
//        return posts.get((int) (id - 1));
        return postsDao.findById(id);
    }

    public Post save(Post post) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
        return postsDao.save(post);
    }

    public void delete(long id) {
        postsDao.delete(id);
    }

//    public void createDummyList() {
//        save(new Post(1L, "First Post", "First Body"));
//        save(new Post(2L, "Second Post", "Second Body"));
//        save(new Post(3L, "Third Post", "Third Body"));
//    }
}
