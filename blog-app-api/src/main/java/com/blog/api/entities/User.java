package com.blog.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name", nullable = false,length = 50)
    @NotEmpty(message = "User Name is required !!")
    @Size(min = 3,max = 50, message ="User Name is must be 3 to 50 characters !!" )
    private String name;

    @NotEmpty(message = "Email is required !!")
    @Email(message = "Email is not valid !!")
    private String email;

    @NotEmpty(message = "Password is required !!")
    @Size(min = 3, message ="Password is must be atLeast 6 characters !!" )
    private String password;

    @NotEmpty(message = "About is required !!")
    @Size(min = 3,max = 200, message ="About is must be 3 to 200 characters !!" )
    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();
}
