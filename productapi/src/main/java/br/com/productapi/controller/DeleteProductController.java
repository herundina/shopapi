package br.com.productapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.service.product.DeleteProductService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/samce/productapi")
@RequiredArgsConstructor
public class DeleteProductController {
    
    private final DeleteProductService service;

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        try {
            this.service.deleteProduct(id);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(
                "O producto não foi deletado. O producto não existe!"
            );
        }
    }
}
