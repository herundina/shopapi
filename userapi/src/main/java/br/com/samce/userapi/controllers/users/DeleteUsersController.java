package br.com.samce.userapi.controllers.users;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.services.users.DeleteUsersServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/userapi")
@RequiredArgsConstructor
public class DeleteUsersController {
    
    private final DeleteUsersServices services;

    @DeleteMapping("/delete/{id}")
    public UserDto delete(@PathVariable Long id){
        return this.services.delete(id);
    }
}