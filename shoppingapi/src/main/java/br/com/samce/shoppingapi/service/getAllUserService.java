package br.com.samce.shoppingapi.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.dto.convertTo.ShopToDto;
import br.com.samce.shoppingapi.model.MShop;
import br.com.samce.shoppingapi.repository.RShop;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class getAllUserService {
    
    private final RShop repository;

    public List<ShopDto> getByUser(String identifier){

        return this.repository
            .findByUserIdentifierIgnoreCase(identifier)
            .stream()
            .map(ShopToDto::convert)
            .collect(Collectors.toList());
    }
}
