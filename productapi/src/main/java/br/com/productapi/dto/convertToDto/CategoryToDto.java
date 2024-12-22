package br.com.productapi.dto.convertToDto;

import br.com.productapi.dto.CategoryDto;
import br.com.productapi.model.MCategory;
import lombok.Data;

public class CategoryToDto {
    
    public static CategoryDto convert(MCategory mCategory){

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(mCategory.getId());
        categoryDto.setNome(mCategory.getNome());

        return categoryDto;
    }
}