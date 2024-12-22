package br.com.samce.userapi.services.users;

import org.springframework.stereotype.Service;

import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.model.MUser;
import br.com.samce.userapi.repository.RUsers;
import br.com.shoppingclient.exeption.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindUserByCpfService {
    
    private final RUsers repository;

    public UserDto getByCpf(String cpf, String key){
        
        System.out.println("SErvico " + cpf +" = " + key);

        MUser user = this.repository.findByCpfAndKey(cpf, key);
        System.out.println("Servico " + user);
       
        if(user != null){
            return ConvertToUserDto.convert(user);
        }
        
        throw new UserNotFoundException();
    }
}
