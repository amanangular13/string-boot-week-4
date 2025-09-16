package com.Aman.productionReadyFeatures.services;

import com.Aman.productionReadyFeatures.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO getPostById(Long postId);
}
