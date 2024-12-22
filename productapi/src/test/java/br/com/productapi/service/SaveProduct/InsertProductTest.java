package br.com.productapi.service.SaveProduct;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.productapi.model.MCategory;
import br.com.productapi.model.MProduct;
import br.com.productapi.repository.RCategory;
import br.com.productapi.repository.RProduct;
import br.com.productapi.service.product.InsertProductService;
import static br.com.productapi.service.saveCategory.InsertCategory.getCategory;

@ExtendWith(MockitoExtension.class)
public class InsertProductTest {
    
    @InjectMocks
    private InsertProductService service;

    @Mock
    private RProduct repository;

    @Mock private RCategory rcategory;

    public static MProduct getProduct(Long id, String productIdentifier){
        
        MProduct product = new MProduct();

        product.setId(id);
        product.setNome("Televisao");
        product.setDescricao("Tv de Plasma");
        product.setProductIdentifier(productIdentifier);
        product.setPreco(1000F);

        MCategory category = getCategory(1L, "Eletrodomestico");
        
        product.setCategory(category);

        System.out.println("InsertProductTest => " + category);
    
        return product;
    }
/*
    @Test
    public void saveProductTest(){

        MProduct product  = getProduct(
            1L, "Televisao de Plasma");

        ProductDto productDto = ProductToDto.convert(product);

        Mockito.when(this.repository.save(Mockito.any())).thenReturn(product);
  
        ProductDto dtoProduct = this.service.save(productDto);
        Assertions.assertEquals("Televisao de Plasma", dtoProduct.getProduct_identifier());        
        Assertions.assertEquals(1, dtoProduct.getCategory().getId());
    } */

}