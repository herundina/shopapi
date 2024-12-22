package br.com.productapi.model.convertToEntity;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.model.MProduct;

public class ProductToEntity {
    
    public static MProduct convert(ProductDto productDto){

        MProduct mProduct = new MProduct();

        mProduct.setId(productDto.getId());
        mProduct.setNome(productDto.getNome());
        mProduct.setDescricao(productDto.getDescricao());
        mProduct.setProductIdentifier(productDto.getProduct_identifier());
        mProduct.setPreco(productDto.getPreco());
        
       if(productDto.getCategory() != null){
            mProduct.setCategory(
               CategoryToEntity.convert(productDto.getCategory())
            );
       }
        
        return mProduct;
    }
}