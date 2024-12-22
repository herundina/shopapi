package br.com.shoppingclient.dto.errorMsgExcption;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    
    private int codigo;
    private String message;
    private LocalDateTime timeStamp;
}
