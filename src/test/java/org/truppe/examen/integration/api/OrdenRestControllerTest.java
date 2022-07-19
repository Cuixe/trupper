package org.truppe.examen.integration.api;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.truppe.examen.entity.Orden;
import org.truppe.examen.entity.Producto;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrdenRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String URL = "http://localhost:";

    @Test
    void saveOrderTest() {
        Orden orden = new Orden();
        for(int i = 1; i<=5;i++) {
            Producto producto = new Producto();
            producto.setCodigo("12345"+i);
            producto.setDescripcion("Producto_" + i);
            producto.setPrecio(i);
            orden.getProductos().add(producto);
            orden.setTotal(orden.getTotal() + producto.getPrecio());
        }
        orden.setFecha(LocalDate.now());
        Orden result = restTemplate.postForObject(URL + port + "/api/orden", orden, Orden.class);
        Assert.assertTrue(result.getId() > 0);
    }

    @Test
    void getById() {
        Orden result = restTemplate.getForObject(URL + port + "/api/orden/1",  Orden.class);
        Assert.assertEquals(1,result.getId());

        Assert.assertEquals(1,result.getProductos().size());

    }

    @Test
    void update() {
        //Orden orden = new Orden();
        Orden orden = restTemplate.getForObject(URL + port + "/api/orden/1",  Orden.class);
        orden.setTotal(200);

        restTemplate.put(URL + port + "/api/orden",  orden);

        Orden result = restTemplate.getForObject(URL + port + "/api/orden/1",  Orden.class);
        Assert.assertEquals(1,result.getId());
        Assert.assertEquals(200, result.getTotal());


    }



}
