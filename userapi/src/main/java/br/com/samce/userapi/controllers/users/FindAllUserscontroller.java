package br.com.samce.userapi.controllers.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.services.users.GetAllUsersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/userapi")
@RequiredArgsConstructor
public class FindAllUserscontroller {

    private final GetAllUsersService service;

    @GetMapping("/usuarios")
    public List<UserDto> findAllUsers(){
        return this.service.getAllUsers();
    }
}
