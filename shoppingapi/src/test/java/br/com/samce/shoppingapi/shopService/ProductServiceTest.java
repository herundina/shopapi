package br.com.samce.shoppingapi.shopService;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.samce.shoppingapi.service.comunicationApi.ProductService;
import br.com.shoppingclient.dto.product.ProductDto;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    public static MockWebServer mockWebServer;

    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setUp() throws IOException{
        mockWebServer = new MockWebServer();
        mockWebServer.start();  
        
        String baseUrl = String.format(
            "http://localhost:%s", 
            mockWebServer.getPort()
        );

        System.out.println("baseUrl . " + baseUrl);
        ReflectionTestUtils.setField(service, "productApiURL", baseUrl);
    }

    @AfterEach
    void tearDown() throws IOException{
        mockWebServer.shutdown();   
    }

    @Test
    public void test_findProductByIdentifier() throws Exception{

        ProductDto product  = new ProductDto();
        product.setProduct_identifier("Tv de plasma");
        product.setPreco(100F);

        ObjectMapper objectMapper = new ObjectMapper();

        mockWebServer.enqueue(new MockResponse()
            .setBody(objectMapper.writeValueAsString(product))
            .addHeader("Contenty-Type" , "application/json")
        );

        product = this.service.findProductByIdentifier("Tv de plasma");

        Assertions.assertEquals("Tvplasma", product.getProduct_identifier());
        Assertions.assertEquals(100F, product.getPreco());

  }
}