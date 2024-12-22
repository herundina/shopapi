package br.com.samce.userapi.converts;

import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.model.MUser;

public class ConvertToUserDto {
    
    public static UserDto convert(MUser user){
        UserDto userDto = 
            new UserDto(
                user.getNomeUsuario(), 
                user.getKey(),
                user.getCpf(), 
                user.getEndereco(), 
                user.getEmail(), 
                user.getTelefone(),
                user.getDtCadastro());                
        return userDto;
    }
}
