package br.com.samce.userapi.converts;

import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.model.MUser;

public class ConvertToMUsers {
    
    public static MUser convert(UserDto userDto){
      MUser mUser = 
        new MUser();

        mUser.setNomeUsuario(userDto.getNomeUsuario());
        mUser.setKey(userDto.getKey());
        mUser.setCpf(userDto.getCpf());
        mUser.setEndereco(userDto.getEndereco());
        mUser.setEmail(userDto.getEmail());
        mUser.setTelefone(userDto.getTelefone());
        mUser.setDtCadastro(userDto.getDtCadastro());
 
        return mUser;
    }
}
