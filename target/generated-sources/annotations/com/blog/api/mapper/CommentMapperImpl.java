package com.blog.api.mapper;

import com.blog.api.entities.Comment;
import com.blog.api.entities.User;
import com.blog.api.payloads.CommentDTO;
import com.blog.api.payloads.UserDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-01T15:05:21+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment commentDTOToComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( commentDTO.getCommentId() );
        comment.setMessage( commentDTO.getMessage() );
        comment.setUser( userDTOToUser( commentDTO.getUser() ) );

        return comment;
    }

    @Override
    public CommentDTO commentToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setCommentId( comment.getCommentId() );
        commentDTO.setMessage( comment.getMessage() );
        commentDTO.setUser( userToUserDTO( comment.getUser() ) );

        return commentDTO;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setAbout( userDTO.getAbout() );

        return user;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId( user.getUserId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setAbout( user.getAbout() );

        return userDTO;
    }
}
