package br.com.shoppingclient.dto.shop;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
        
    @NotNull @NotBlank
    private String product_identifier;

    @NotNull
    private Float preco;

}
