package br.com.samce.shoppingapi.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.samce.shoppingapi.dto.IRelatorio;
import br.com.samce.shoppingapi.model.MShop;

@Repository
public interface RShop extends JpaRepository<MShop, Long>{

    //All itens by user identifier 
    List<MShop> findByUserIdentifierIgnoreCase(String UserIdentifier);

    //Retorna todas as compras com valor total maiores ao passao ao parametro GreaterThan(valores maiores que)
    List<MShop> findByTotalCompraGreaterThan(Float preco);

    //All as compras realizadas a partir da data passado por parametro
    List<MShop> findByDtCompraGreaterThan(LocalDateTime dtCompra);

    @Query("""
             select              
                count(s.id) as qtidadeCompras , 
                sum(s.totalCompra) as total , 
                avg(s.totalCompra) as media 
                from shop s where s.dtCompra >= ?1 and s.dtCompra <= ?2
            """ )
    IRelatorio findByDtCompra(LocalDateTime dtInicio, LocalDateTime dtFim);

    @Query("""
        select s from shop s 
        where s.dtCompra >= ?1 
        or s.dtCompra <= ?2 
        or s.totalCompra >= ?3        
        """)    
    List<MShop> findAllByDtCompra(
        @Param("dtInicio") LocalDateTime dtInicio, 
        @Param("dtFim") LocalDateTime dtFim, 
        @Param("valorMinimo") Float valorMinimo);
}
