package com.blog.api.services;

import com.blog.api.entities.Post;
import com.blog.api.payloads.PostDTO;
import com.blog.api.payloads.PostResponseDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO,Integer userId,Integer categoryId);

    PostDTO updatePost(PostDTO postDTO,Integer postId);

    PostDTO getPostById(Integer postId);

    void deletePost(Integer postId);

    PostResponseDTO getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    List<PostDTO> getPostsByCategory(Integer categoryId);

    List<PostDTO> getPostsByUser(Integer userId);

    List<PostDTO> searchPost(String keyword);
}
