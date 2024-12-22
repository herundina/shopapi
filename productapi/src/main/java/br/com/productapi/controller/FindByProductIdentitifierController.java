package br.com.productapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.service.product.GetProductByIdentifierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class FindByProductIdentitifierController {
    
    private final GetProductByIdentifierService service;

    @GetMapping("/identifier/{identifier}")
    public ProductDto findByIdentifier(@PathVariable String identifier){
        return this.service.findByProductIdentifier(identifier);
    }
}
