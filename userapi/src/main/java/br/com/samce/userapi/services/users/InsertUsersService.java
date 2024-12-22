package br.com.samce.userapi.services.users;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;
import br.com.samce.userapi.converts.ConvertToMUsers;
import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.repository.RUsers;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsertUsersService {
    
    private final RUsers repository;

    public UserDto save(UserDto userDto){

        userDto.setKey(UUID.randomUUID().toString());
        userDto.setDtCadastro(LocalDateTime.now());

        return ConvertToUserDto.convert(
            this.repository.save(
                ConvertToMUsers.convert(userDto)
            ));
    }
}