package com.blog.api.mapper;

import com.blog.api.entities.Comment;
import com.blog.api.payloads.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE= Mappers.getMapper(CommentMapper.class);

    Comment commentDTOToComment(CommentDTO commentDTO);
    CommentDTO commentToCommentDTO(Comment comment);
}
