package com.example.Spring_Security.services;

import com.example.Spring_Security.dto.PostDto;
import com.example.Spring_Security.entities.PostEntity;
import com.example.Spring_Security.exceptions.ResourceNotFoundException;
import com.example.Spring_Security.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        List<PostEntity> allPostEntity = postRepository.findAll();
        return allPostEntity.stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDto.class))
                .toList();
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("PostId not found: " + postId));
        return modelMapper.map(postEntity, PostDto.class);
    }


    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        PostEntity savedEntity = postRepository.save(postEntity);
        return modelMapper.map(savedEntity,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        PostEntity olderPost = postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post with id: " + postId +" not found"));
        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);
        PostEntity savePostEntity = postRepository.save(olderPost);
        return modelMapper.map(savePostEntity,PostDto.class);
    }

}
