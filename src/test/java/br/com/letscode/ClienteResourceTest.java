package br.com.letscode;

import org.hamcrest.CoreMatchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import br.com.letscode.model.Cliente;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.h2.H2DatabaseTestResource;


import static io.restassured.RestAssured.given;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteResourceTest {
  
    @Test
    @Order(1)
    public void listaClientes(){
        given()
            .when().get("/cliente/lista")
            .then()
            .statusCode(200);
    }

    @Test
    @Order(2)
    public void deletaCliente(){
        given()
        .pathParam("id",1)
        .when().delete("/cliente/{id}")
        .then().statusCode(200);

    }

}
