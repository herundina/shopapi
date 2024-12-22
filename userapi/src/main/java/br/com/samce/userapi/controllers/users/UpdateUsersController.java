package br.com.samce.userapi.controllers.users;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.services.users.UpdateUsersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/userapi")
@RequiredArgsConstructor
public class UpdateUsersController {
    
    private final UpdateUsersService service;

    @PutMapping("/update/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto){
        return this.service.update(id, userDto);
    }
}
