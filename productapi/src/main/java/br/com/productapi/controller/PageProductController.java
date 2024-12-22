package br.com.productapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.service.product.PageProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class PageProductController {
 
    private final PageProductService service;

    @GetMapping("/page")
    public Page<ProductDto> pageProduct(Pageable page){
        return this.service.pageOfProduct(page);
    }
}