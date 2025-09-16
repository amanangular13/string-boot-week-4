package com.Aman.productionReadyFeatures.controllers;

import com.Aman.productionReadyFeatures.dto.PostDTO;
import com.Aman.productionReadyFeatures.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(path = "/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.createPost(postDTO);
    }

    @PutMapping(path = "/{postId}")
    public PostDTO updatePost(@RequestBody PostDTO inputPost, @PathVariable Long postId) {
        return postService.updatePost(inputPost, postId);
    }
}
