package com.blog.api.payloads;

import com.blog.api.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private int commentId;

    @NotEmpty(message = "Message is required !!")
    @Size(min = 3,max = 2000,message = "Message must be 3 to 2000 characters !!")
    private String message;

    private UserDTO user;

}
