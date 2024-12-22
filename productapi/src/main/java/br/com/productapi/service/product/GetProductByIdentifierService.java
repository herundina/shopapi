package br.com.productapi.service.product;

import org.springframework.stereotype.Service;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.dto.convertToDto.ProductToDto;
import br.com.productapi.model.MProduct;
import br.com.productapi.repository.RProduct;
import br.com.shoppingclient.exeption.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetProductByIdentifierService {
    
    private final RProduct repository;

    public ProductDto findByProductIdentifier(String identifier){
        
        MProduct product = this.repository.findByProductIdentifier(identifier);

        if(product != null){
            return ProductToDto.convert(product);
        }

        throw new ProductNotFoundException();
    }

}
