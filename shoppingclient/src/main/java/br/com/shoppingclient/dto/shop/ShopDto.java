package br.com.shoppingclient.dto.shop;

//import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    
    @NotNull
    private String user_identifier;

    @NotNull
    private Float totalCompra;
    
    //@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dtCompra;

    @NotNull
    private List<ItemDto> items;
}
