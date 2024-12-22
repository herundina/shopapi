package br.com.samce.shoppingapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.getAllUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindAllByuserIdentifierController {
    
    private final getAllUserService service;

    @GetMapping("/usuario/{identifier}")
    public List<ShopDto> findAllUserById(
            @RequestParam(name = "identifier") String identifier
        ){
        return this.service.getByUser(identifier);
    }
}
