package com.blog.api.entities;

import jakarta.persistence.*;
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
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @NotEmpty(message = "Title is required !!")
    @Size(min = 3,max = 50,message = "Title must be 3 to 50 characters !!")
    private String title;

    @NotEmpty(message = "Description is required !!")
    @Size(min = 3,max = 200,message = "Description must be 3 to 200 characters !!")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();

}
