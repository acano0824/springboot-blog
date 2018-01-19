package com.codeup.springbootblog.controllers;


import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    private final PostService postSvc;

    public PostsController(PostService postSvc) {
        this.postSvc = postSvc;
    }


    @GetMapping("/posts")
    public String posts(Model viewModel) {
//        List<Post> posts = new ArrayList<>();
//        Post post1 = new Post(1L,"first title", "first body");
//        Post post2 = new Post(2L, "second title", "second body");
//        posts.add(post1);
//        posts.add(post2);

        viewModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model viewModel) {
//        Post post = new Post(1L, "first post title", "first post body");

        viewModel.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model viewModel) {
        Post post = new Post();
        viewModel.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@ModelAttribute Post post) {
        postSvc.save(post);
        return post.getTitle() + " " + post.getBody();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model viewModel) {
        Post existingPost = postSvc.findOne(id);
        viewModel.addAttribute("post", existingPost);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        post.setId(id);
        postSvc.save(post);
        return "redirect:/posts/{id}";
    }


}
