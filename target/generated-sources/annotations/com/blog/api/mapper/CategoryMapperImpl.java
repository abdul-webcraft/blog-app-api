package com.blog.api.mapper;

import com.blog.api.entities.Category;
import com.blog.api.payloads.CategoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T19:42:23+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        return category;
    }

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> categoryListToCategoryDTOList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( categoryToCategoryDTO( category ) );
        }

        return list;
    }
}
