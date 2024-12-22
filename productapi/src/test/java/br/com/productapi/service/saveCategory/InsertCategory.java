package br.com.productapi.service.saveCategory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.productapi.dto.CategoryDto;
import br.com.productapi.dto.convertToDto.CategoryToDto;
import br.com.productapi.model.MCategory;
import br.com.productapi.repository.RCategory;
import br.com.productapi.service.product.InsertCategoryServices;

@ExtendWith(MockitoExtension.class)
public class InsertCategory {

    @InjectMocks
    private InsertCategoryServices service;

    @Mock
    private RCategory repository;

    public static MCategory getCategory(Long id, String nome){
        MCategory category = new MCategory();

        category.setId(id);
        category.setNome(nome);

        return category;
    }

    @Test
    public void testCategoryInsert(){

        MCategory categoryEntity = getCategory(1L, "Eletrodomestico");
        CategoryDto categoryDto = CategoryToDto.convert(categoryEntity);

        Mockito.when(this.repository.save(Mockito.any())).thenReturn(categoryEntity);

        CategoryDto dto = this.service.saveCategory(categoryDto);

        Assertions.assertEquals(1L, dto.getId());
        Assertions.assertEquals("Eletrodomestico", dto.getNome());
    }
}