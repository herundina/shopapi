package br.com.productapi.dto.convertToDto;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.model.MProduct;
import lombok.Data;

public class ProductToDto {
    
    public static ProductDto convert(MProduct mProduct){

        ProductDto productDto = new ProductDto();

        productDto.setId(mProduct.getId());
        productDto.setNome(mProduct.getNome());
        productDto.setDescricao(mProduct.getDescricao());
        productDto.setPreco(mProduct.getPreco());
        productDto.setProduct_identifier(mProduct.getProductIdentifier());

        if(mProduct.getCategory() != null){
            productDto.setCategory(
                CategoryToDto.convert(mProduct.getCategory())
            );
        }

        return productDto;
    }
}