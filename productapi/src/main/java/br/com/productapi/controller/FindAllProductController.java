package br.com.productapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.service.product.FindAllProductsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class FindAllProductController {
    
    private final FindAllProductsService service;

    @GetMapping("/products")
    public List<ProductDto> findAll(){
        return this.service.getAllProducts();
    }

}
