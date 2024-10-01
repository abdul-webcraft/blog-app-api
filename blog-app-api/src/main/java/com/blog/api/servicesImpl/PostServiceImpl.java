package com.blog.api.servicesImpl;

import com.blog.api.entities.Category;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.mapper.PostMapper;
import com.blog.api.payloads.PostDTO;
import com.blog.api.payloads.PostResponseDTO;
import com.blog.api.repositories.CategoryRepository;
import com.blog.api.repositories.PostRepository;
import com.blog.api.repositories.UserRepository;
import com.blog.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    private final PostMapper postMapper=PostMapper.INSTANCE;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
        Post post = postMapper.postDTOToPost(postDTO);
        post.setImage("default.png");
        post.setPostedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post createdPost = postRepository.save(post);
        return postMapper.postToPostDTO(createdPost);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImage(postDTO.getImage());
        Post updatedPost = postRepository.save(post);
        return postMapper.postToPostDTO(updatedPost);
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
        return postMapper.postToPostDTO(post);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
        postRepository.delete(post);
    }

    @Override
    public PostResponseDTO getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Post> postPage = postRepository.findAll(pageable);
        List<Post> allPost = postPage.getContent();
        List<PostDTO> postDTOList = postMapper.postListToPostDTOLIst(allPost);
        PostResponseDTO postResponseDTO=new PostResponseDTO();
        postResponseDTO.setContent(postDTOList);
        postResponseDTO.setPageNumber(postPage.getNumber());
        postResponseDTO.setPageSize(postPage.getSize());
        postResponseDTO.setTotalElements(postPage.getTotalElements());
        postResponseDTO.setTotalPages(postPage.getTotalPages());
        postResponseDTO.setLastPage(postPage.isLast());
        return postResponseDTO;
    }

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
        List<Post> posts = postRepository.findByCategory(category);
        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getPostsByUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
        List<Post> posts = postRepository.findByUser(user);
        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        List<Post> posts = postRepository.findByTitleContaining(keyword);
        return postMapper.postListToPostDTOLIst(posts);
    }

}
