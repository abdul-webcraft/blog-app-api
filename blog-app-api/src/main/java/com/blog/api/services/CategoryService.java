package com.blog.api.services;

import com.blog.api.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(int categoryId,CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(int categoryId);
    List<CategoryDTO> getAllCategory();
    void deleteCategory(int categoryId);
}
