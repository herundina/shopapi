package br.com.productapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.productapi.model.MProduct;

@Repository
public interface RProduct  extends JpaRepository<MProduct, Long>{

//Consultas 
    //Busca de todos os products de um determinada Category - id vem da Rota
    @Query("""
            SELECT p FROM product p 
            Where p.category.id = ?1
            """)
    public List<MProduct> findProductByCategoryId(@Param("categoryId") Long categoryId);

    //Busca por identifier
    public MProduct findByProductIdentifier(String productIdentifier);
   
}