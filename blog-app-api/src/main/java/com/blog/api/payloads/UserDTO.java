package com.blog.api.payloads;

import com.blog.api.entities.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int userId;

    @NotBlank(message = "User Name is required !!")
    @Size(min = 3,max = 50, message ="User Name is must be 3 to 50 characters !!" )
    private String name;

    @NotBlank(message = "Email is required !!")
    @Email(message = "Email is not valid !!")
    private String email;

    @NotBlank(message = "Password is required !!")
    @Size(min = 6, message ="Password is must be atLeast 6 characters !!" )
    private String password;

    @NotBlank(message = "About is required !!")
    @Size(min = 3,max = 200, message ="About is must be 3 to 200 characters !!" )
    private String about;

}
