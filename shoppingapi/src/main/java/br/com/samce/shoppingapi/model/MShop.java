package br.com.samce.shoppingapi.model;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shop")
public class MShop {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "userIdentifier", length = 150, nullable = false)
    private String userIdentifier;

    @Column(name = "totalCompra", nullable = false)
    private Float totalCompra;

    @CreationTimestamp
    @Column(name = "dtCompra", nullable = false)
    private LocalDateTime dtCompra;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "shop_item" , 
        joinColumns = @JoinColumn(name = "shopid"))
    private List<MItem> items;
}
