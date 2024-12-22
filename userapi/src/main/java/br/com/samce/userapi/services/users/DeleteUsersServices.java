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
public class DeleteUsersServices {
    
    private final RUsers repository;

    public UserDto delete(Long id) throws UserNotFoundException{
        MUser muser = this.repository.findById(id)
            .orElseThrow(
                () -> new UserNotFoundException());        
        this.repository.delete(muser);
        return ConvertToUserDto.convert(muser);
    }
}
