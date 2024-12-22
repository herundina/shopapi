package br.com.productapi.controller.Category;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.dto.CategoryDto;
import br.com.productapi.service.product.InsertCategoryServices;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("samce/productapi/category")
public class InsertCateogryController {
    
    private final InsertCategoryServices service;

    @PostMapping("/novo")
    public CategoryDto saveCategory(@RequestBody CategoryDto category) {
        
        return this.service.saveCategory(category);
    }

    @GetMapping("/list")
    public List<CategoryDto> listAll(){
        return this.service.findAll();
    }
    
}
