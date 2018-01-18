package com.codeup.springbootblog.controllers;


import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    @GetMapping("/posts")
    public String posts(Model viewModel) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("first title", "first body");
        Post post2 = new Post("second title", "second body");
        posts.add(post1);
        posts.add(post2);
        viewModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model viewModel) {
        Post post = new Post("first post title", "first post body");
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "view the form for creating a post";
    }

    @RequestMapping
    @ResponseBody
    public String newPost() {
        return "create a new post";
    }

}
