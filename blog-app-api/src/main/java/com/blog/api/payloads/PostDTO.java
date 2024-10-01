package com.blog.api.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    private int postId;

    @NotEmpty(message = "Title is required !!")
    @Size(min = 3,max = 50,message = "Title must be 3 to 50 characters !!")
    private String title;

    @NotEmpty(message = "Content is required !!")
    @Size(min = 3,max = 1000,message = "Content must be 3 to 1000 characters !!")
    private String content;

    private String image;

    private Date postedDate;

    private CategoryDTO category;

    private UserDTO user;

    private Set<CommentDTO> comments=new HashSet<>();
}
