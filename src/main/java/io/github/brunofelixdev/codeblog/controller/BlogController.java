package io.github.brunofelixdev.codeblog.controller;

import io.github.brunofelixdev.codeblog.model.Post;
import io.github.brunofelixdev.codeblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/posts")
    public ModelAndView getPosts() {
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> posts = blogService.buscarTodosPosts();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView getPostsDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Post post = blogService.buscarPostPorId(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
}
