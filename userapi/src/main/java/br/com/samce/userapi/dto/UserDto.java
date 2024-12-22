package br.com.samce.userapi.dto;

import java.time.LocalDateTime;

import org.springframework.data.web.JsonPath;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  
    @NotNull @NotBlank(message = "Nome é campo Obrigatório")private String nomeUsuario;

    @NotNull @NotBlank(message = "key é campo obrigatório") private String key;

    @NotNull @NotBlank(message = "CPF é campo obrigatório") private String cpf;    

    private String endereco;    

    @NotNull @NotBlank(message = "Email é campo Obrigatório") private String email;

    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dtCadastro;   
}