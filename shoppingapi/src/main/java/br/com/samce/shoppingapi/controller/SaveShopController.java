package br.com.samce.shoppingapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.SaveShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class SaveShopController {
    
    private final SaveShopService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDto save(
        @Valid @RequestBody ShopDto shop,
        @RequestHeader(name = "key" , required = true) String key
        ){
        System.out.println("Controller " + shop);
        return this.service.save(shop, key);
    }
}
