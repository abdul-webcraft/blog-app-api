package com.blog.api.mapper;

import com.blog.api.entities.Comment;
import com.blog.api.payloads.CommentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T19:42:21+0530",
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

        return comment;
    }

    @Override
    public CommentDTO commentToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        return commentDTO;
    }
}
