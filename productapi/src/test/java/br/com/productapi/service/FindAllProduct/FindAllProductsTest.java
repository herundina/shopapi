package br.com.productapi.service.FindAllProduct;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.model.MProduct;
import br.com.productapi.repository.RProduct;
import br.com.productapi.service.SaveProduct.InsertProductTest;
import br.com.productapi.service.product.FindAllProductsService;

@ExtendWith(MockitoExtension.class)
public class FindAllProductsTest {
    
    @InjectMocks()
    private FindAllProductsService service;

    @Mock
    private RProduct repository;

    @Test
    public void findAllProductTest(){
 
        List<MProduct> productdto = new ArrayList<>();
 
        productdto.add(
            InsertProductTest.getProduct(
                1L, "Som wirelles")
        );

        Mockito.when(this.repository.findAll()).thenReturn(productdto);

        List<ProductDto> product = this.service.getAllProducts();

        Assertions.assertEquals(1, product.size());

    }

}