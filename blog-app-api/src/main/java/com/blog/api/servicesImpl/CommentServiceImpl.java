package com.blog.api.servicesImpl;

import com.blog.api.entities.Comment;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.mapper.CommentMapper;
import com.blog.api.payloads.CommentDTO;
import com.blog.api.repositories.CommentRepository;
import com.blog.api.repositories.PostRepository;
import com.blog.api.repositories.UserRepository;
import com.blog.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    private final CommentMapper commentMapper=CommentMapper.INSTANCE;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postId,Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
        Comment comment = commentMapper.commentDTOToComment(commentDTO);
        comment.setPost(post);
        comment.setUser(user);
        Comment createdComment = commentRepository.save(comment);
        return commentMapper.commentToCommentDTO(createdComment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "comment Id", commentId));
        commentRepository.delete(comment);
    }
}
