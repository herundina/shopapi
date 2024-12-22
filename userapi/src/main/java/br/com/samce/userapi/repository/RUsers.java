package br.com.samce.userapi.repository;

import java.util.List;
import br.com.samce.userapi.model.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RUsers extends JpaRepository<MUser, Long>{
    
    List<MUser> queryByNomeUsuarioLike(String nome);

   
    public MUser findByCpfAndKey(@Param("cpf") String cpf , @Param("key") String key);
}