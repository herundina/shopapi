package br.com.samce.userapi.controllerTest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import br.com.samce.userapi.controllers.users.FindAllUserscontroller;
import br.com.samce.userapi.converts.ConvertToUserDto;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.serviceTest.insertTest.InsertUsersServiceTest;
import br.com.samce.userapi.services.users.GetAllUsersService;

@ExtendWith(MockitoExtension.class)
public class FindAllUserscontrollerTest {
    
    @InjectMocks
    private FindAllUserscontroller controlller;

    @Mock
    private GetAllUsersService service;

    private MockMvc mockMvc;

    /*
     * Os testes ficam aqui
     */

     @Test
     public void testListUsers () throws Exception{

       List<UserDto> userDto = new ArrayList<>();

        userDto.add(
            ConvertToUserDto.convert(
                InsertUsersServiceTest.getUser(1, "Herun", "123321456")));

        Mockito.when(this.service.getAllUsers()).thenReturn(userDto);

        //Fazer solicitação ao serviço        
        MvcResult result = 
            this.mockMvc
                .perform(MockMvcRequestBuilders.get("/samce/userapi/usuarios")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8))                
                .andExpect(MockMvcResultMatchers.status().isOk())                             
                .andReturn();
                
        String resultJson = result.getResponse().getContentAsString();                
        //comprado com uma json o resultado da chamada do recurso
        Assertions.assertEquals("[{\"nomeUsuario\":\"Herun\",\"key\":null,\"cpf\":\"123321456\",\"endereco\":\"Rua dos Pombos\",\"email\":null,\"telefone\":\"78456\",\"dtCadastro\":null}]", resultJson);
     }

     @BeforeEach
     public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controlller).build();
     }
}
