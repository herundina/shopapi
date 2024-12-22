package br.com.samce.shoppingapi.model.ConvertTo;

import java.util.stream.Collectors;

import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.model.MShop;

public class ShopToEntity {
    
    public static final MShop convert(ShopDto shop){

        MShop mShop = new MShop();

        mShop.setUserIdentifier(shop.getUser_identifier());        
        mShop.setDtCompra(shop.getDtCompra());

        if(shop.getItems() != null){
            mShop.setItems(
               shop.getItems()
               .stream()
               .map(ItemToEntity::convert)
               .collect(Collectors.toList())
            );
        }

        mShop.setTotalCompra(shop.getTotalCompra());

        return mShop;
    }
}