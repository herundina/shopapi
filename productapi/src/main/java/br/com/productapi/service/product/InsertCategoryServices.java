package br.com.productapi.service.product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.productapi.dto.CategoryDto;
import br.com.productapi.dto.convertToDto.CategoryToDto;
import br.com.productapi.model.convertToEntity.CategoryToEntity;
import br.com.productapi.repository.RCategory;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsertCategoryServices {
    
    private final RCategory repository;

    public CategoryDto saveCategory(CategoryDto category){        
        return CategoryToDto.convert(
            this.repository.save(
                CategoryToEntity.convert(category)
            ));
    }

    public List<CategoryDto> findAll(){
        return this.repository.findAll().stream().map(CategoryToDto::convert).collect(Collectors.toList());
    }
}
