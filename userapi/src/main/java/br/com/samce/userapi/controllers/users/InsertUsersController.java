package br.com.samce.userapi.controllers.users;

import org.springframework.web.bind.annotation.RestController;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.services.users.InsertUsersService;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/samce/userapi")
@RequiredArgsConstructor
public class InsertUsersController {

    public static List<UserDto> usuarios = new ArrayList<>();
    
    private final InsertUsersService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto save(@RequestBody UserDto userDto){       
        return this.service.save(userDto);
    }

    /*
    @PostConstruct
    public void insertDados(){

        UserDto user1 = new UserDto();

        user1.setNome("Herundina");
        user1.setCpf("79779889");
        user1.setEndereco("Endereco");
        user1.setTelefone("88999");
        user1.setEmail("sdsdsd");
        user1.setDtCadastro(LocalDateTime.now());

        UserDto user2 = new UserDto();

        user2.setNome("Herundina");
        user2.setCpf("79779889");
        user2.setEndereco("Endereco");
        user2.setTelefone("88999");
        user2.setEmail("sdsdsd");
        user2.setDtCadastro(LocalDateTime.now());

       usuarios.add(user1);
       usuarios.add(user2);

    }

//Endpoints 

    @DeleteMapping("/delete/{cpf}")
    public boolean deleteUser(@PathVariable String cpf){
        return this.usuarios.removeIf(u -> u.getCpf().equals(cpf));
    }

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto setUsuario(@RequestBody @Valid UserDto user){
        user.setDtCadastro(LocalDateTime.now());
        this.usuarios.add(user);
        return user;
    }
    
    @GetMapping("/usuarios")
    public List<UserDto> getUsuarios() {
        return this.usuarios;
    }

    @GetMapping("/usuario/{cpf}")
    public UserDto getUsuario(@PathVariable String cpf){
        return this.usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst().orElseThrow(() -> new RuntimeException("Usuário não foi cadastrado!"));
    }
*/
}