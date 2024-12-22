package br.com.productapi.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.productapi.dto.ProductDto;
import br.com.productapi.dto.convertToDto.ProductToDto;
import br.com.productapi.repository.RProduct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageProductService {
    
    private final RProduct repository;

    public Page<ProductDto> pageOfProduct(Pageable page){
        return this.repository.findAll(page).map(ProductToDto::convert);
    }
}
