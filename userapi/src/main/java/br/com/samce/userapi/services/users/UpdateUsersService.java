package br.com.samce.userapi.services.users;

import org.springframework.stereotype.Service;

import br.com.samce.userapi.converts.ConvertToMUsers;
import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.model.MUser;
import br.com.samce.userapi.repository.RUsers;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateUsersService {
    
    private final RUsers repository;

    public UserDto update(Long id, UserDto userDto){
        return this.repository.findById(id)
            .map(data -> 
                {
                    MUser user = ConvertToMUsers.convert(userDto);

                    data.setNomeUsuario(userDto.getNomeUsuario());
                    data.setCpf(userDto.getCpf());
                    data.setEndereco(userDto.getEndereco());
                    data.setEmail(userDto.getEmail());
                    data.setTelefone(userDto.getTelefone());

                    return ConvertToUserDto.convert(this.repository.save(user));
                }
            ).orElseThrow(() -> new RuntimeException("Não foi possível Atualizar Usuário. Contate o setor de TI!"));
    }
}