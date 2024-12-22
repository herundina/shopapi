package br.com.samce.shoppingapi.service.comunicationApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.shoppingclient.dto.user.UserDto;
import br.com.shoppingclient.exeption.UserNotFoundException;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    
    @Value("${USER_API_URL:http://localhost:8080/samce/userapi}")
    private String userApiUrl;
    
    public UserDto findByUserCpfAndKey(String cpf, String key){

        try {
            
            WebClient web = 
                WebClient.builder()
                .baseUrl(this.userApiUrl)
                .build();
            
            Mono<UserDto> user =    
                web.get()
                .uri("/userbyCpf/"+cpf+"?="+key)
                .retrieve()
                .bodyToMono(UserDto.class);
                
            return user.block();

        } catch (RuntimeException e) {            
            throw new UserNotFoundException();
        }        
    }
}