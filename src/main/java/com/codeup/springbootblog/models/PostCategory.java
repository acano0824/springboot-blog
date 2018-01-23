package com.codeup.springbootblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class PostCategory {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;
}
