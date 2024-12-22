package br.com.samce.userapi.controllerAdvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.shoppingclient.dto.errorMsgExcption.ErrorDto;
import br.com.shoppingclient.exeption.UserNotFoundException;



@RestControllerAdvice(basePackages = "br.com.samce.userapi.controllers.users")
public class UserControllerAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDto handlerUserNotfound( UserNotFoundException userNotFoundException ){
        
        ErrorDto error = new ErrorDto();

        error.setCodigo(HttpStatus.NOT_FOUND.value());
        error.setMessage("""
                Usuário não Encontrado. 
                Verifique os dados informados. 
                ou Cadastra Usuário!
                """);
        error.setTimeStamp(LocalDateTime.now());
        return error;
    }
}
