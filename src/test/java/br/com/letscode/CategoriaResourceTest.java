package br.com.letscode;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class CategoriaResourceTest {
    @Test
    public void listaCategorias(){
        given()
            .when().get("/categoria/lista")
            .then()
            .statusCode(200);
    }
}
