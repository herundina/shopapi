package br.com.samce.shoppingapi.model.ConvertTo;

import br.com.samce.shoppingapi.dto.ItemDto;
import br.com.samce.shoppingapi.model.MItem;

public class ItemToEntity {
    
    public static final MItem convert(ItemDto item){

        MItem mItem = new MItem();

        mItem.setProduct_identifier(item.getProduct_identifier());
        mItem.setPreco(item.getPreco());

        return mItem;
    }
}