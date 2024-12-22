package br.com.shoppingclient.dto.user;

import java.time.LocalDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    
    @NotBlank(message = "Nome é campo Obrigatório")private String nomeUsuario;
    
    @NotBlank(message = "CPF é campo obrigatório") private String cpf;
    
    private String endereco;    
   
    @NotBlank(message = "Email é campo Obrigatório") private String email;
    
    private String telefone;
   
    private LocalDateTime dtCadastro;

}
