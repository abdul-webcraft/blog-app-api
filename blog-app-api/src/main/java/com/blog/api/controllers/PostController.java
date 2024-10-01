package com.blog.api.controllers;

import com.blog.api.config.AppConstants;
import com.blog.api.payloads.ApiResponse;
import com.blog.api.payloads.PostDTO;
import com.blog.api.payloads.PostResponseDTO;
import com.blog.api.services.ImageService;
import com.blog.api.services.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/v1/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ImageService imageService;

    @Value("$(project.image)")
    private String path;

    @PostMapping("user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId,@PathVariable Integer categoryId){
        PostDTO postDTO1 = postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<>(postDTO1, HttpStatus.CREATED);
    }

    @PutMapping("post/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,@PathVariable Integer postId){
        PostDTO postDTO1 = postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(postDTO1,HttpStatus.OK);
    }

    @DeleteMapping("post/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ApiResponse("Post Deleted Successfully !!",true);
    }

    @GetMapping("user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> postsByUser(@PathVariable Integer userId){
        List<PostDTO> postsByUser = postService.getPostsByUser(userId);
        return ResponseEntity.ok(postsByUser);
    }

    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> postsByCategory(@PathVariable Integer categoryId){
        List<PostDTO> postsByCategory = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postsByCategory);
    }

    @GetMapping("posts")
    public ResponseEntity<PostResponseDTO> allPost(@RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
                                                   @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
                                                   @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false)String sortBy,
                                                   @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false)String sortDir){
        PostResponseDTO allPost = postService.getAllPost(pageNumber, pageSize,sortBy,sortDir);
        return ResponseEntity.ok(allPost);
    }

    @GetMapping("post/{postId}")
    public ResponseEntity<PostDTO> postById(@PathVariable Integer postId){
        PostDTO postById = postService.getPostById(postId);
        return ResponseEntity.ok(postById);
    }

    @GetMapping("posts/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchByTitle(@PathVariable String keyword){
        List<PostDTO> postDTOList = postService.searchPost(keyword);
        return ResponseEntity.ok(postDTOList);
    }

    //post image upload
    @PutMapping("post/{postId}/image")
    public ResponseEntity<PostDTO> uploadPostImage(@RequestParam("image") MultipartFile image,@PathVariable Integer postId) throws IOException {
        PostDTO postDTO = postService.getPostById(postId);
        String fileName = this.imageService.uploadImage(path, image);
        postDTO.setImage(fileName);
        PostDTO updatedPost = postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @GetMapping(value = "post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable String imageName, HttpServletResponse response)throws IOException{
        InputStream resource=imageService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }


}
