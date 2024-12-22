package br.com.samce.shoppingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samce.shoppingapi.dto.ItemDto;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.dto.convertTo.ShopToDto;
import br.com.samce.shoppingapi.model.ConvertTo.ShopToEntity;
import br.com.samce.shoppingapi.repository.RShop;
import br.com.samce.shoppingapi.service.comunicationApi.ProductService;
import br.com.samce.shoppingapi.service.comunicationApi.UserService;
import br.com.shoppingclient.dto.product.ProductDto;
import br.com.shoppingclient.dto.user.UserDto;
import br.com.shoppingclient.exeption.ProductNotFoundException;
import br.com.shoppingclient.exeption.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveShopService {

    private final RShop repository;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final UserService userService;

    public ShopDto save(ShopDto shopDto, String key){  
        
        UserDto user = this.userService
            .findByUserCpfAndKey(shopDto.getUser_identifier(), key );
     
        //Buscando recurso usuario se existe
        if(
            user == null
        ){            
           throw new UserNotFoundException();
        }
        
        //Validando produto não vier itens no shopDto retorna null
        if(!validateProductsItem(shopDto.getItems())){
            throw new ProductNotFoundException();
        }

        shopDto.setTotalCompra(
            shopDto.getItems()
            .stream()
            .map(total -> total.getPreco())
            .reduce((float) 0, Float::sum)
            );
        
        shopDto.setDtCompra(LocalDateTime.now());
        
        System.out.println("Service save " + shopDto);
        
        return ShopToDto.convert(
            this.repository.save(
                ShopToEntity.convert(shopDto)
            )
        );
    }    

    public boolean validateProductsItem(List<ItemDto> items){
        for(ItemDto item : items){

            ProductDto product = 
                this.productService.findProductByIdentifier(item.getProduct_identifier());
            
                //Verifica se o produto existe
                if(product == null){
                    return false;
                }
            //set o preço na variavel preco de itemDto
            item.setPreco(product.getPreco());
        }

        return true;
    }
}