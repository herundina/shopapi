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
public class QueryByParamsServices {
    
    private final RUsers repository;

    public List<UserDto> getAllParams(String params){
        return this.repository.queryByNomeUsuarioLike(params)
            .stream()
            .map(ConvertToUserDto::convert)
            .collect(Collectors.toList());
    }
}
