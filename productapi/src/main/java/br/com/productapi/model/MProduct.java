package br.com.productapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class MProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "product_identifier", nullable = false, length = 150)
    private String productIdentifier;

    @Column(name = "descricao", nullable = false, length = 250)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Float preco;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MCategory category;
    
}
