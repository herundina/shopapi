package br.com.samce.shoppingapi.service.Relatorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.dto.convertTo.ShopToDto;
import br.com.samce.shoppingapi.repository.RShop;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindShopByFiltersService {
    
    private final RShop repository;

     public List<ShopDto> findAllShopByFilters(
        LocalDate dtInicio, 
        LocalDate dtFim,
        Float valorMinimo){
            System.out.println("dtInicio " + dtInicio + " dtFim " + dtFim +" ValorMinimo => " +valorMinimo);
        return this.repository.findAllByDtCompra(
            dtInicio.atTime(0, 0),  
            dtFim.atTime(23, 29),
            valorMinimo)
            .stream()
            .map(ShopToDto::convert)
            .collect(Collectors.toList());
    } 
}
