package br.com.samce.shoppingapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.dto.convertTo.ShopToDto;
import br.com.samce.shoppingapi.repository.RShop;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class getAllByTotalCompraService {
    
    private final RShop respository;

    public List<ShopDto> findAllByTotalComprar(Float total){
        
        return this.respository
            .findByTotalCompraGreaterThan(total)
            .stream()
            .map(ShopToDto::convert)
            .collect(Collectors.toList());
    }
}
