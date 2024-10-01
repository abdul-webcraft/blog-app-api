package com.blog.api.payloads;

import com.blog.api.entities.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private int categoryId;

    @NotBlank(message = "Title is required !!")
    @Size(min = 3, max = 50, message = "Title must be 3 to 50 characters !!")
    private String title;

    @NotBlank(message = "Description is required !!")
    @Size(min = 3, max = 200, message = "Description must be 3 to 200 characters !!")
    private String description;

}