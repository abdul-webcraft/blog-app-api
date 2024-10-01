package com.blog.api.mapper;

import com.blog.api.entities.Category;
import com.blog.api.entities.Comment;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.payloads.CategoryDTO;
import com.blog.api.payloads.CommentDTO;
import com.blog.api.payloads.PostDTO;
import com.blog.api.payloads.UserDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-01T14:48:43+0530",
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

        post.setPostId( postDTO.getPostId() );
        post.setTitle( postDTO.getTitle() );
        post.setContent( postDTO.getContent() );
        post.setImage( postDTO.getImage() );
        post.setPostedDate( postDTO.getPostedDate() );
        post.setCategory( categoryDTOToCategory( postDTO.getCategory() ) );
        post.setUser( userDTOToUser( postDTO.getUser() ) );
        post.setComments( commentDTOSetToCommentSet( postDTO.getComments() ) );

        return post;
    }

    @Override
    public PostDTO postToPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setPostId( post.getPostId() );
        postDTO.setTitle( post.getTitle() );
        postDTO.setContent( post.getContent() );
        postDTO.setImage( post.getImage() );
        postDTO.setPostedDate( post.getPostedDate() );
        postDTO.setCategory( categoryToCategoryDTO( post.getCategory() ) );
        postDTO.setUser( userToUserDTO( post.getUser() ) );
        postDTO.setComments( commentSetToCommentDTOSet( post.getComments() ) );

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

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDTO.getCategoryId() );
        category.setTitle( categoryDTO.getTitle() );
        category.setDescription( categoryDTO.getDescription() );

        return category;
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

    protected Comment commentDTOToComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( commentDTO.getCommentId() );
        comment.setMessage( commentDTO.getMessage() );
        comment.setUser( userDTOToUser( commentDTO.getUser() ) );

        return comment;
    }

    protected Set<Comment> commentDTOSetToCommentSet(Set<CommentDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Comment> set1 = new LinkedHashSet<Comment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CommentDTO commentDTO : set ) {
            set1.add( commentDTOToComment( commentDTO ) );
        }

        return set1;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId( category.getCategoryId() );
        categoryDTO.setTitle( category.getTitle() );
        categoryDTO.setDescription( category.getDescription() );

        return categoryDTO;
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

    protected CommentDTO commentToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setCommentId( comment.getCommentId() );
        commentDTO.setMessage( comment.getMessage() );
        commentDTO.setUser( userToUserDTO( comment.getUser() ) );

        return commentDTO;
    }

    protected Set<CommentDTO> commentSetToCommentDTOSet(Set<Comment> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentDTO> set1 = new LinkedHashSet<CommentDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Comment comment : set ) {
            set1.add( commentToCommentDTO( comment ) );
        }

        return set1;
    }
}
