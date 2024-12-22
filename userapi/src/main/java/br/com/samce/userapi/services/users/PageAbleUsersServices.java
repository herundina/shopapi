package br.com.samce.userapi.services.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.repository.RUsers;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageAbleUsersServices {
    
    private final RUsers repository;


    public Page<UserDto> getAllpage(Pageable page){
        return this.repository.findAll(page).map(ConvertToUserDto::convert);
    }
}
