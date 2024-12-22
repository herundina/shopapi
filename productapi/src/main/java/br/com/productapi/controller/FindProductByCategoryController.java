package br.com.productapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.productapi.dto.ProductDto;
import br.com.productapi.service.product.GetProductByCategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class FindProductByCategoryController {
    
    private final  GetProductByCategoryService service;

    @GetMapping("/category/{id}")
    public List<ProductDto> getAllProductByCategory(@PathVariable(name = "id") Long id){
        return this.service.getProductByCategory(id);
    }
}
