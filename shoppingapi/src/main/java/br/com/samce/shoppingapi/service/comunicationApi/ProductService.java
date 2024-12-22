package br.com.samce.shoppingapi.service.comunicationApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.shoppingclient.dto.product.ProductDto;
import br.com.shoppingclient.exeption.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    
    @Value("${PRODUCT_API_URL:http://localhost:8081/samce/productapi}")
    private String productApiUrl;

    public ProductDto findProductByIdentifier(String identifier){

        try {
            
            WebClient web = 
                WebClient.builder()
                .baseUrl(this.productApiUrl)
                .build();

            Mono<ProductDto> product = 
                web.get()
                .uri("/identifier/"+identifier)
                .retrieve()
                .bodyToMono(ProductDto.class);

                System.out.println("baseUrl . " + product);
                
                return product.block();
        } catch (Exception e) {
            throw new ProductNotFoundException();
        }
    }
}