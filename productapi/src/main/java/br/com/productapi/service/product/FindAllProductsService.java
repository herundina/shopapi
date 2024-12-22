package br.com.productapi.service.product;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.productapi.dto.ProductDto;
import br.com.productapi.dto.convertToDto.ProductToDto;
import br.com.productapi.repository.RProduct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllProductsService {
    
    private final RProduct repository;

    public List<ProductDto> getAllProducts(){
        return this.repository.findAll()
            .stream()
            .map(ProductToDto::convert)
            .collect(Collectors.toList());
    }
}