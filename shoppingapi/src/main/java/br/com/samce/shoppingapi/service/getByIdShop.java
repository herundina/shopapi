package br.com.samce.shoppingapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.dto.convertTo.ShopToDto;
import br.com.samce.shoppingapi.model.MShop;
import br.com.samce.shoppingapi.repository.RShop;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class getByIdShop {
    
    private final RShop repository;

    public ShopDto getById(Long id){
        Optional<MShop> shop = this.repository.findById(id);  

        if(shop.isPresent()) { 
            return ShopToDto.convert(shop.get()); 
        }

        return null;
    }
}