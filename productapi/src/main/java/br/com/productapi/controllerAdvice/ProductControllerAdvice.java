package br.com.productapi.controllerAdvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.shoppingclient.dto.errorMsgExcption.ErrorDto;
import br.com.shoppingclient.exeption.ProductNotFoundException;

@RestControllerAdvice
public class ProductControllerAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto handlerProductNotFound(
        ProductNotFoundException productNotFoundException
    ){

        ErrorDto error = new ErrorDto();

        error.setCodigo(HttpStatus.NOT_FOUND.value());
        error.setMessage("""
                Produto não Localizado.
                Corriga os dados informados.
                Ou Cadastre o Produto.
                """);
        error.setTimeStamp(LocalDateTime.now());

        return error;
    }
    
}
