package br.com.samce.shoppingapi.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.getAllByTotalCompraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindAllByTotalCompraController {
    
    private final getAllByTotalCompraService service;

    @GetMapping("/totalCompra")
    public  List<ShopDto> findAllByTotalCompra(@RequestParam(name = "total") Float total){
        return this.service.findAllByTotalComprar(total);
    }
}
