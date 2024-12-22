package br.com.productapi.service.product;

import org.springframework.stereotype.Service;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.dto.convertToDto.ProductToDto;
import br.com.productapi.model.MProduct;
import br.com.productapi.model.convertToEntity.CategoryToEntity;
import br.com.productapi.model.convertToEntity.ProductToEntity;
import br.com.productapi.repository.RProduct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateProductService {
    
    private final RProduct repository;

    public ProductDto updateProduct(Long id , ProductDto productDto){

        return 
            this.repository.findById(id)
            .map(
                product -> 
                {
                    MProduct mProduct = ProductToEntity.convert(productDto);
                    
                    return ProductToDto.convert(this.repository.save(mProduct));
                }
            )
            .orElseThrow(
                () -> 
                    new RuntimeException("Não foi possível atualizar Produto. Contate o setor de TI!")
            );
    }
}
