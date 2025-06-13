package test.RestApi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.*;

@Tag("REST Assured Tests")

public class RestApiTests extends TestBaseApi {

    int registeredUserId = 2;
    int newRegisteredUserId = 713;

    @Test
    @DisplayName("1. Поиск зарегистрированного пользователя: Get - Single user")
    void getSingleRegisteredUserTest(){
        given()
                .header(apiKeyName,apiKey)
                .log().uri()
                .when()
                .get(userPath + registeredUserId)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    @DisplayName("2. Регистрация нового пользователя: Post - Create")
    void postCreateNewUserTest() {
        String userJsonBody = "{\"name\": \"Inna Tyulyaeva\", \"year\": \"1991\", \"job\": \"QA\"}";
        given()
                .header(apiKeyName,apiKey)
                .body(userJsonBody)
                .contentType(JSON)
                .log().all()
                .when()
                .post(userPath)
                .then()
                .statusCode(201)
                .body("name", is("Inna Tyulyaeva"))
                .body("year", is("1991"))
                .body("job", is("QA"))
                .log().all();
    }

    @Test
    @DisplayName("3. Удаление зарегистрированного пользователя:  Delete  -  Delete")
    void deleteRegisteredUserTest() {
        given()
                .header(apiKeyName,apiKey)
                .contentType(JSON)
                .log().all()
                .when()
                .delete(userPath + newRegisteredUserId)
                .then()
                .log().status()
                .statusCode(204);
    }

    @Test
    @DisplayName("4. Регистрация пользователя: Post - Register - successful ")
    void postRegisterSuccessfulUserTest() {
        String userCredentialJson =
                "{ \"email\": \"" + userEmail + "\"," +
                " \"password\": \"" + userPass + "\" }";

        given()
                .header(apiKeyName,apiKey)
                .body(userCredentialJson)
                .contentType(JSON)
                .log().uri()
                .when()
                .post(userRegister)
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .log().all();
    }

    @Test
    @DisplayName("5. Авторизация пользователя: Post - Login - successful")
    void postLoginSuccessfulUserTest() {
        String userCredentialJson =
                "{ \"email\": \"" + userEmail + "\"," +
                " \"password\": \"" + userPassLogin + "\" }";

        given()
                .header(apiKeyName,apiKey)
                .body(userCredentialJson)
                .contentType(JSON)
                .log().uri()
                .when()
                .post(userLogin)
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .log().all();
    }

    @Test
    @DisplayName("6. Обновление значений параметров зарегистрированного пользователя: Put - Update")
    void updatingUsersInfoTest() {
        String userJsonBody = "{\"name\": \"Inna Tyulyaeva_1\", \"year\": \"1990\", \"job\": \"QA_1\"}";
        given()
                .header(apiKeyName,apiKey)
                .body(userJsonBody)
                .contentType(JSON)
                .log().uri()
                .when()
                .put(userPath + newRegisteredUserId)
                .then()
                .statusCode(200)
                .body("name", is("Inna Tyulyaeva_1"))
                .body("year", is("1990"))
                .body("job", is("QA_1"))
                .log().all();
    }

    @Test
    @DisplayName("7. Обновление значений параметров зарегистрированного пользователя: Patch - Update")
    void patchingUsersJobTest() {
        String userJsonBody = "{\"year\": \"1992\"}";
        given()
                .header(apiKeyName,apiKey)
                .body(userJsonBody)
                .contentType(JSON)
                .log().uri()
                .when()
                .patch(userPath + newRegisteredUserId)
                .then()
                .statusCode(200)
                .body("year", is("1992"))
                .log().all();
    }
}
