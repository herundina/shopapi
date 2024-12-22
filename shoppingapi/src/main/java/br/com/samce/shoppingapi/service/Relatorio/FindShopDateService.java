package br.com.samce.shoppingapi.service.Relatorio;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import br.com.samce.shoppingapi.dto.IRelatorio;
import br.com.samce.shoppingapi.repository.RShop;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindShopDateService {

    private final RShop repository;

    public IRelatorio findShopByDateIF
    (
        LocalDate dtInicio,
        LocalDate dtFim
    ){

      dtInicio.atTime(0, 0);
      dtFim.atTime(23, 29);

      System.out.println("Service " + dtInicio + " = " + dtInicio.atTime(0, 0));

      

    return this.repository.findByDtCompra(dtInicio.atTime(0, 0), dtFim.atTime(23, 29));
    }
}