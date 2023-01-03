package io.github.brunofelixdev.codeblog.controller;

import io.github.brunofelixdev.codeblog.model.Post;
import io.github.brunofelixdev.codeblog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {

    final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

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

    @GetMapping("/newpost")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping("/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes)  {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        blogService.salvarPost(post);
        return "redirect:/posts";
    }
}
