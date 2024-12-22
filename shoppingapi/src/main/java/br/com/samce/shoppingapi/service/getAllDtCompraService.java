package br.com.samce.shoppingapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.dto.convertTo.ShopToDto;
import br.com.samce.shoppingapi.repository.RShop;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class getAllDtCompraService {
    
    private final RShop repository;

    public List<ShopDto> getByDtCompra(LocalDate data){
        return this.repository
        .findByDtCompraGreaterThan(data.atTime(0, 0))
        .stream()
        .map(ShopToDto::convert)
        .collect(Collectors.toList());
    }


}
