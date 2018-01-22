package com.codeup.springbootblog.daos;

import com.codeup.springbootblog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("Select p from Post p where p.id=?1")
    Post findById(long id);
}
