package br.com.productapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.productapi.dto.ProductDto;
import br.com.productapi.service.product.UpdateProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class UpdateProductController {
    
    private final UpdateProductService service;

    @PostMapping("/atualizar")
    public ProductDto update(
            @RequestParam(name = "productid") Long id , 
            @RequestBody ProductDto productDto
        )
        {
        return this.service.updateProduct(id, productDto);
    }
}
