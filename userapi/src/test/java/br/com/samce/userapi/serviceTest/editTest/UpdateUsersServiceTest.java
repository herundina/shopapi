package br.com.samce.userapi.serviceTest.editTest;

import java.util.Optional;

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
import br.com.samce.userapi.serviceTest.insertTest.InsertUsersServiceTest;
import br.com.samce.userapi.services.users.UpdateUsersService;

@ExtendWith(MockitoExtension.class)
public class UpdateUsersServiceTest {
    
    @InjectMocks
    private UpdateUsersService service;

    @Mock
    private RUsers repository;

    @Test
    public void testEditUser(){
        
        MUser mUser = 
            InsertUsersServiceTest.getUser(
                1, "Herundina F Lima", "123456789");

        //busca pelo id
        Mockito.when(this.repository.findById(1L))
            .thenReturn(Optional.of(mUser));

        //salvar
        Mockito.when(this.repository.save(Mockito.any())).thenReturn(mUser);

        //Passando alterações

        UserDto userDto = ConvertToUserDto.convert(mUser);    
        userDto.setNomeUsuario("Dina Lima");    
        userDto.setCpf("321654987");
        userDto.setEndereco("Novo Endereco");
        userDto.setTelefone("Novo Telefone");
        
        //Testando o método  updade e comparando o retorno 
        UserDto dtoUser = this.service.update(1L, userDto);
        Assertions.assertEquals("Dina Lima", dtoUser.getNomeUsuario());
        Assertions.assertEquals("321654987", dtoUser.getCpf());
        Assertions.assertEquals("Novo Endereco", dtoUser.getEndereco());
        Assertions.assertEquals("Novo Telefone", dtoUser.getTelefone());
    }
}