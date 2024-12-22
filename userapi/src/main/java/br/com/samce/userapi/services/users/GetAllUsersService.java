package br.com.samce.userapi.services.users;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.repository.RUsers;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAllUsersService {
    
    //injeção de Dependencia
    private final RUsers repository;

    //return all users
    public List<UserDto> getAllUsers(){
        return this.repository.findAll()
            .stream()
            .map(ConvertToUserDto::convert)
            .collect(Collectors.toList());
    }

}
