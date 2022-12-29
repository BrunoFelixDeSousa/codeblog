package io.github.brunofelixdev.codeblog.service;

import io.github.brunofelixdev.codeblog.model.Post;

import java.util.List;

public interface BlogService {

    List<Post> buscarTodosPosts();
    Post buscarPostPorId(Long id) throws IllegalArgumentException;
    Post salvarPost(Post post);
}
