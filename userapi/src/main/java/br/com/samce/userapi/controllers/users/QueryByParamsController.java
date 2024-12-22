package br.com.samce.userapi.controllers.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.services.users.QueryByParamsServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samce/userapi")
@RequiredArgsConstructor
public class QueryByParamsController {

    private final QueryByParamsServices services;

    @GetMapping("/pesquisar")
    public List<UserDto> getAllParams(
        @RequestParam(name = "nome" , required = true) String params){
        return this.services.getAllParams(params);
    }
}
