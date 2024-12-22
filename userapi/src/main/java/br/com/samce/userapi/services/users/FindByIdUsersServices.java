package br.com.samce.userapi.services.users;

import org.springframework.stereotype.Service;

import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.repository.RUsers;
import br.com.shoppingclient.exeption.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindByIdUsersServices {
    
    private final RUsers repository;    

    public UserDto findById(Long id){
       return this.repository.findById(id)
        .map(ConvertToUserDto::convert)
        .orElseThrow(()-> new ProductNotFoundException());
    }
}