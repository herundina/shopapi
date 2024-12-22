package br.com.samce.userapi.dto;

import java.time.LocalDateTime;

public record UserRecord(
    String nome, 
    String telefone,
    String cpf,
    String endereco,
    String email,
    LocalDateTime crt
) {
    
}
