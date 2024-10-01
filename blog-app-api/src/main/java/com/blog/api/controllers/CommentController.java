package com.blog.api.controllers;

import com.blog.api.payloads.ApiResponse;
import com.blog.api.payloads.CommentDTO;
import com.blog.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("user/{userId}/post/{postId}/comment")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO,@PathVariable Integer postId,@PathVariable Integer userId){
        CommentDTO comment = commentService.createComment(commentDTO, postId,userId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("comment/{commentId}")
    public ApiResponse deleteComment(@PathVariable Integer commentId){
        commentService.deleteComment(commentId);
        return new ApiResponse("Comment deleted successfully",true);
    }
}
