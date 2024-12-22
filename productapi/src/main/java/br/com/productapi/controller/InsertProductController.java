package br.com.productapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.service.product.InsertProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class InsertProductController {
    
    private final InsertProductService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto insertProduct(@RequestBody ProductDto product){
        System.out.println("Controller "  + product);
        return this.service.save(product);
    }
}