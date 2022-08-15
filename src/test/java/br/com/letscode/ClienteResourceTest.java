package br.com.letscode;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ClienteResourceTest {
  
    @Test
    public void listaClientes(){
        given()
            .when().get("/cliente/lista")
            .then()
            .statusCode(200);
    }

    //'ES012345678','Ana', 'ana@email.com', '19'
    // @Test
    // public void alteraDados(){
    //     Cliente registroOriginal = given()
    //     .when().get("/cliente/2")
    //     .then()
    //     .statusCode(200).extract().as(Cliente.class);

    //     JSONObject requestBody = new JSONObject()
    //     .put("nome","Anna" )
    //     .put("email","anna@email.com" )
    //     .put("idade","29")
    //     .put("vatnumber","ES012345678");

    //     given()
    //     .header("content-type","application/json")
    //     .body(requestBody.toString())
    //     .put("/cliente/2")
    //     .then().statusCode(200).extract().as(Cliente.class);

    //     Cliente registroAlterado = given()
    //     .when().get("/cliente/2")
    //     .then()
    //     .statusCode(200).extract().as(Cliente.class);

    // }
}
