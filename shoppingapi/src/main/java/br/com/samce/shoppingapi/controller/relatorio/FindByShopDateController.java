package br.com.samce.shoppingapi.controller.relatorio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.shoppingapi.dto.IRelatorio;
import br.com.samce.shoppingapi.service.Relatorio.FindShopDateService;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/samce/shoppingapi")
@RequiredArgsConstructor
public class FindByShopDateController {
    
    private final FindShopDateService service;

    @GetMapping("/shopbydate")
    public IRelatorio relatorio (
        @RequestParam(name = "dtInicio" , required = true) 
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtInicio, 
        @RequestParam(name = "dtFim" , required = true)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtFim
    ){        
        return this.service.findShopByDateIF(dtInicio, dtFim);
    }
}