package br.com.samce.userapi.controllers.users;

import lombok.RequiredArgsConstructor;
import br.com.samce.userapi.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.samce.userapi.services.users.FindUserByCpfService;

@RestController
@RequestMapping("/samce/userapi/")
@RequiredArgsConstructor
public class FindByCpfController {

    private final FindUserByCpfService service;

    @GetMapping("/userbyCpf/{cpf}")
    public UserDto getByCpf(
        @PathVariable(name = "cpf") String cpf,
        @RequestParam(name = "key", required = true) String key
    ){        
        return this.service.getByCpf(cpf, key);
    }
}