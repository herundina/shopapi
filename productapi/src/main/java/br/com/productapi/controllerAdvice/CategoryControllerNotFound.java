package br.com.productapi.controllerAdvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.shoppingclient.dto.errorMsgExcption.ErrorDto;
import br.com.shoppingclient.exeption.CategoryNotFoundException;

@RestControllerAdvice
public class CategoryControllerNotFound {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorDto handleCategoryNotFound( 
        CategoryNotFoundException categoryNotFoundException
    ){

        ErrorDto error = new ErrorDto();

        error.setCodigo(HttpStatus.NOT_FOUND.value());
        error.setMessage("""
                Categoria de produto não encontrado.
                Corriga as informações.
                Ou Cadastro a Categoria!
                """);
        error.setTimeStamp(LocalDateTime.now());

        return error;
    }

    

}
