package br.com.samce.userapi.serviceTest.insertTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.model.MUser;
import br.com.samce.userapi.repository.RUsers;
import br.com.samce.userapi.services.users.InsertUsersService;

@ExtendWith(MockitoExtension.class)
public class InsertUsersServiceTest {
    
    @InjectMocks
    private InsertUsersService service; // classe que estar sendo testada

    @Mock
    private RUsers repository; //dependencia

    //Metodo para criar objetos da class usuario

    public static MUser getUser(Integer id, String nome, String cpf){

        MUser user = new MUser();
        user.setId(id);
        user.setNomeUsuario(nome);
        user.setCpf(cpf);
        user.setEndereco("Rua dos Pombos");
        user.setTelefone("78456");

        return user;
    }

    @Test
    public void testSaveUser(){
        MUser user = getUser(1, "Maria Clara da Silva", "1234567887");
        UserDto userDto = ConvertToUserDto.convert(user);

        Mockito.when(this.repository.save(Mockito.any())).thenReturn(user);

        UserDto dtoUser = this.service.save(userDto);
        Assertions.assertEquals("Maria Clara da Silva" , dtoUser.getNomeUsuario());
        Assertions.assertEquals("1234567887", dtoUser.getCpf());

    }
}