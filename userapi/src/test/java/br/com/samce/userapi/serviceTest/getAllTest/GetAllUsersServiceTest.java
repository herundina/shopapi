package br.com.samce.userapi.serviceTest.getAllTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.samce.userapi.dto.UserDto;
import br.com.samce.userapi.model.MUser;
import br.com.samce.userapi.repository.RUsers;
import br.com.samce.userapi.serviceTest.insertTest.InsertUsersServiceTest;
import br.com.samce.userapi.services.users.GetAllUsersService;

@ExtendWith(MockitoExtension.class)
public class GetAllUsersServiceTest {
    
    @InjectMocks
    private GetAllUsersService service;

    @Mock
    private RUsers repository;

    @Test
    public void testListAllUsers(){

        List<MUser> users = new ArrayList<>();

        users.add(
            InsertUsersServiceTest.getUser(
                1, "Herundina F Lima", "123456789"
            ));
        users.add(
            InsertUsersServiceTest.getUser(
                1, "Cecilia F Lima", "987654321"
            ));

        Mockito.when(this.repository.findAll()).thenReturn(users);

        List<UserDto> usersRetorn = this.service.getAllUsers();

        Assertions.assertEquals(2, usersRetorn.size());
    }
}