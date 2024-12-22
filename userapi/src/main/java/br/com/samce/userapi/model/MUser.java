package br.com.samce.userapi.model;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class MUser {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", length = 150 , nullable = false)
    private String nomeUsuario;

    @Column(name = "key", length = 100 , nullable = false)
    private String key;

    @Column(name = "cpf", length = 11 , nullable = false)
    private String cpf;

    @Column(name = "endereco", length = 250 , nullable = false)
    private String endereco;

    @Column(name = "email", length = 150 , nullable = false)
    private String email;

    @Column(name = "telefone", length = 150 , nullable = false)
    private String telefone;

    @Column(name = "dtCadastro", length = 150 , nullable = false)
    private LocalDateTime dtCadastro;


}