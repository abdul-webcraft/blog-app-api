package com.blog.api.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Role {

    private int roleId;
    private String roleName;

}
