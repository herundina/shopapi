package br.com.samce.shoppingapi.controller.relatorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.service.Relatorio.FindShopByFiltersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindAllShoyByFiltersController {
    
    private final FindShopByFiltersService service;

   @GetMapping("/byfilters")
    public List<ShopDto> findByFilters(
        @RequestParam(name = "dtInicio" , required = true)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtInicio,
        @RequestParam(name = "dtFim" , required = false) 
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtFim,
        @RequestParam(name = "total", required = false) Float total
    ){
        return this.service.findAllShopByFilters(dtInicio, dtFim, total);
    }
}