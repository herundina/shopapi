package br.com.samce.shoppingapi.dto.convertTo;

import java.util.stream.Collectors;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.model.MShop;

public class ShopToDto {

    public static final ShopDto convert(MShop shop){
     
        ShopDto shopDto = new ShopDto();

        shopDto.setUser_identifier(shop.getUserIdentifier());
        shopDto.setTotalCompra(shop.getTotalCompra());
        shopDto.setDtCompra(shop.getDtCompra());
        
        if(shop.getItems() != null){
            shopDto.setItems(
                shop.getItems()
                    .stream()
                    .map(ItemToDto::convert)
                    .collect(Collectors.toList())
            );
        }

        return shopDto;
    }
    
}