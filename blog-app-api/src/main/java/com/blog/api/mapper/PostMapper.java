package com.blog.api.mapper;

import com.blog.api.entities.Category;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.payloads.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper  INSTANCE=Mappers.getMapper(PostMapper.class);

    Post postDTOToPost(PostDTO postDTO);

    PostDTO postToPostDTO(Post post);

    List<PostDTO> postListToPostDTOLIst(List<Post> postList);

}
