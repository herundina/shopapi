package br.com.productapi.service.product;

import org.springframework.stereotype.Service;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.dto.convertToDto.ProductToDto;
import br.com.productapi.model.MProduct;
import br.com.productapi.model.convertToEntity.CategoryToEntity;
import br.com.productapi.model.convertToEntity.ProductToEntity;
import br.com.productapi.repository.RCategory;
import br.com.productapi.repository.RProduct;
import br.com.shoppingclient.exeption.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsertProductService {

    private final RProduct repository;
    private final RCategory repositoryCategory;

    public ProductDto save(ProductDto product) {
        MProduct mproduct = ProductToEntity.convert(product);

        System.out.print(mproduct);

        if(!getExistsCategory(mproduct.getCategory().getId())){            
            throw new CategoryNotFoundException();
        }
        
        if(product.getCategory() != null){
            mproduct.setCategory(
                CategoryToEntity.convert(product.getCategory())               
            );
        }            
        return ProductToDto.convert(this.repository.save(mproduct));
    }

    public boolean getExistsCategory(Long id){
        System.out.println(this.repositoryCategory.existsById(id));
        return this.repositoryCategory.existsById(id);
    }
}