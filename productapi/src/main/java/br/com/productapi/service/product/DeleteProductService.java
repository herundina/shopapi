package br.com.productapi.service.product;

import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.productapi.model.MProduct;
import br.com.productapi.repository.RProduct;
import br.com.shoppingclient.exeption.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final RProduct repository;

    public void deleteProduct(Long id){
        Optional<MProduct> product =  this.repository.findById(id);

        if(product.isPresent()){
            this.repository.delete(product.get());
        }
        throw new ProductNotFoundException();
    }
}