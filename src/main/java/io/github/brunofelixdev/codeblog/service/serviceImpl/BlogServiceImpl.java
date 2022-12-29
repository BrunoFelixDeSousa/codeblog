package io.github.brunofelixdev.codeblog.service.serviceImpl;

import io.github.brunofelixdev.codeblog.model.Post;
import io.github.brunofelixdev.codeblog.repository.BlogRepository;
import io.github.brunofelixdev.codeblog.service.BlogService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Post> buscarTodosPosts() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Post buscarPostPorId(Long id) throws IllegalArgumentException {
        Optional<Post> post = blogRepository.findById(id);

        if(post.isEmpty()) {
            throw new IllegalArgumentException("Id não encontrado");
        } else {
            return post.get();
        }

    }

    @Override
    public Post salvarPost(Post post) {
        return blogRepository.save(post);
    }

}
