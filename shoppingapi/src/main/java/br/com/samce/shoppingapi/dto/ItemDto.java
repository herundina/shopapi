package br.com.samce.shoppingapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class ItemDto {
    
    @NotNull @NotBlank
    private String product_identifier;

    @NotNull
    private Float preco;
}
