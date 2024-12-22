package br.com.samce.shoppingapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MItem {

    @Column(name = "product_identifier", length = 150 , nullable = false)
    private String product_identifier;

    @Column(name = "preco", nullable = false)
    private Float preco;
}
