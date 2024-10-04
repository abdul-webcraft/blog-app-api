package com.blog.api.mapper;

import com.blog.api.entities.Post;
import com.blog.api.payloads.PostDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T19:42:16+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post postDTOToPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        return post;
    }

    @Override
    public PostDTO postToPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        return postDTO;
    }

    @Override
    public List<PostDTO> postListToPostDTOLIst(List<Post> postList) {
        if ( postList == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( postList.size() );
        for ( Post post : postList ) {
            list.add( postToPostDTO( post ) );
        }

        return list;
    }
}
