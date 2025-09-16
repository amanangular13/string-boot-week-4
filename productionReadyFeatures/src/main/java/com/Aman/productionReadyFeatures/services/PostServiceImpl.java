package com.Aman.productionReadyFeatures.services;

import com.Aman.productionReadyFeatures.dto.PostDTO;
import com.Aman.productionReadyFeatures.entities.PostEntity;
import com.Aman.productionReadyFeatures.exceptions.ResourceNotFoundException;
import com.Aman.productionReadyFeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        return modelMapper.map(
                postRepository.save(modelMapper.map(postDTO, PostEntity.class)),
                PostDTO.class);
    }
}
