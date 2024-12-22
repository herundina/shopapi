package br.com.samce.shoppingapi.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.getAllDtCompraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindAllByDtCompraController {
    
    private final getAllDtCompraService service;

    @GetMapping("/dtCompra")
    public List<ShopDto> findAllByDtCompra(
        @RequestParam 
        @DateTimeFormat(iso = ISO.DATE) LocalDate shop){
        return this.service.getByDtCompra(shop);
    }
}
