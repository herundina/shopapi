package br.com.productapi.model.convertToEntity;

import br.com.productapi.dto.CategoryDto;
import br.com.productapi.model.MCategory;

public class CategoryToEntity {

    public static MCategory convert(CategoryDto categoryDto){

        MCategory mCategory = new MCategory();

        mCategory.setId(categoryDto.getId());
        mCategory.setNome(categoryDto.getNome());
        
        return mCategory; 
    }
    
}