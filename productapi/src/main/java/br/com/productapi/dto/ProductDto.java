package br.com.productapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    
    //@JsonProperty("_id") 
    //@JsonIgnore
    private Long id;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String product_identifier;

    @NotNull @NotBlank
    private String descricao;

    @NotNull
    private Float preco;
    
    @NotNull
    private CategoryDto category;
}
