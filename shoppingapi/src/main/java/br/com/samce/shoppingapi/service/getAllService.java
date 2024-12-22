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
public class getAllService {
    
    private final RShop repository;

    public List<ShopDto> getAllShop(){
        return this.repository.findAll()
            .stream()
            .map(ShopToDto::convert)
            .collect(Collectors.toList());
    }
}