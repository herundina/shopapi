package br.com.samce.shoppingapi.shopService;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.samce.shoppingapi.dto.ItemDto;
import br.com.samce.shoppingapi.dto.ShopDto;
import br.com.samce.shoppingapi.model.ConvertTo.ShopToEntity;
import br.com.samce.shoppingapi.repository.RShop;
import br.com.samce.shoppingapi.service.SaveShopService;
import br.com.samce.shoppingapi.service.comunicationApi.ProductService;
import br.com.samce.shoppingapi.service.comunicationApi.UserService;
import br.com.shoppingclient.dto.product.ProductDto;
import br.com.shoppingclient.dto.user.UserDto;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {
/*
    @InjectMocks
    private SaveShopService saveShopService;

    @Mock
    private RShop repository;

    @Mock
    private UserService userService;

    @Mock
    private ProductService productService;

    //Save recebe list<item>, user, 
  
    @Test
    public void testSaveUser() throws  RuntimeException {

        ItemDto itemDto = new ItemDto();
        itemDto.setPreco(100F);
        itemDto.setProduct_identifier("Tv de Plasma");

        ShopDto shopDto = new ShopDto();
        shopDto.setUser_identifier("123456789");
        shopDto.setItems(new ArrayList<>());
        shopDto.getItems().add(itemDto);
        shopDto.setTotalCompra(100F);

        ProductDto productDto = new ProductDto();
        productDto.setProduct_identifier("Tv de Plasma");
        productDto.setPreco(100F);

        //user
        Mockito.when(
            this.userService.findByUserCpfAndKey("123456789", "123456789"))
            .thenReturn(new UserDto());

        //product // verifica se a chamada ao Método retorna um product. se não, não comonicou com a API product
        Mockito.when(
            this.productService.findProductByIdentifier("Tv de Plasma"))
            .thenReturn(productDto);

        //save compra        
        Mockito.when(this.repository.save(Mockito.any()))
            .thenReturn(ShopToEntity.convert(shopDto));

        //Testando o método save da camada de servico

        shopDto = this.saveShopService.save(shopDto, "123456789");

        
       Assertions.assertEquals(100F, shopDto.getTotalCompra());
       Assertions.assertEquals(1, shopDto.getItems().size());

       Mockito.verify(this.repository, Mockito.times(1)).save(Mockito.any());
    } */
}