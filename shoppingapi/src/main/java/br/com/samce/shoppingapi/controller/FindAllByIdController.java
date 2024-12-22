package br.com.samce.shoppingapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.getByIdShop;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindAllByIdController {
    
    private final getByIdShop service;

    @GetMapping("/samce/{id}")
    public ShopDto findById(@PathVariable(name = "id") Long id){
        return this.service.getById(id);
    }
}
