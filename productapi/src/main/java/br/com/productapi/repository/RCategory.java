package br.com.productapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productapi.model.MCategory;

@Repository
public interface RCategory extends JpaRepository<MCategory, Long>{
    
    List<MCategory> findAll();

    boolean existsById(Long id);
}
