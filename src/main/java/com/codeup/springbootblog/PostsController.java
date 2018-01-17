package com.codeup.springbootblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    @RequestMapping("/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @RequestMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable Long id) {
        return "view post #" + id;
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
