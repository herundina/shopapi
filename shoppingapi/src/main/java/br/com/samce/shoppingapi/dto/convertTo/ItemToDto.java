package br.com.samce.shoppingapi.dto.convertTo;

import br.com.samce.shoppingapi.dto.ItemDto;
import br.com.samce.shoppingapi.model.MItem;

public class ItemToDto {

    public static final ItemDto convert(MItem item){

        ItemDto itemDto = new ItemDto();

        itemDto.setProduct_identifier(item.getProduct_identifier());
        itemDto.setPreco(item.getPreco());

        return itemDto;
    }
    
}
