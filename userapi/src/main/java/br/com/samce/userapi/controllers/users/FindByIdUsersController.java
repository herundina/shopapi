package br.com.samce.userapi.controllers.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.services.users.FindByIdUsersServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/userapi")
@RequiredArgsConstructor
public class FindByIdUsersController {
 
    private static FindByIdUsersServices services;

    @GetMapping("/usuario/{id}")
    public UserDto getUsuario(@PathVariable Long id){
        return this.services.findById(id);
    }
}
