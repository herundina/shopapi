package br.com.samce.shoppingapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.getAllService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindAllShoppingController {
    
    private final getAllService service;

    @GetMapping("/shopping")
    public List<ShopDto> findAllShopping(){
        return this.service.getAllShop();
    }
}
