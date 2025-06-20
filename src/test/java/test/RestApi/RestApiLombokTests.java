package test.RestApi;

import models.lombok.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static specs.RestApiSpec.baseResponseSpecification;
import static specs.RestApiSpec.baseRequestSpecification;

@Tag("REST Assured Tests")

public class RestApiLombokTests extends TestBaseApi {

    int registeredUserId = 2;
    int newRegisteredUserId = 713;
    public String getUserEmail = "janet.weaver@reqres.in";

    @Test
    @Tag("rest_api")
    @DisplayName("1. Поиск зарегистрированного пользователя: Get - Single user")
    void getSingleRegisteredUserTest() {
        GetResponseSingleUserModel response = step("Запрос на поиск зарегистрированного пользователя", () ->
                given(baseRequestSpecification)
                        .when()
                        .get(userPath + registeredUserId)
                        .then()
                        .spec(baseResponseSpecification(200))
                        .extract().as(GetResponseSingleUserModel.class));
        step("Проверка ответа", () -> {

            assertEquals(registeredUserId, response.getData().getId());
            assertEquals(getUserEmail, response.getData().getEmail());
        });
    }

    @Test
    @Tag("rest_api")
    @DisplayName("2. Регистрация нового пользователя: Post - Create")
    void postCreateNewUserTest() {
        CreateUserModels authData = new CreateUserModels("Inna Tyulyaeva", "QA", "1991");
        CreateResponseUserModel response = step("Запрос на регистрацию нового пользователя", () ->
                given(baseRequestSpecification)
                        .body(authData)
                        .when()
                        .post(userPath)
                        .then()
                        .spec(baseResponseSpecification(201))
                        .extract().as(CreateResponseUserModel.class));

        step("Проверка запроса", () -> {
            assertEquals("Inna Tyulyaeva", response.getName());
            assertEquals("QA", response.getJob());
            assertEquals("1991", response.getYear());
        });
    }

    @Test
    @Tag("rest_api")
    @DisplayName("3. Удаление зарегистрированного пользователя:  Delete  -  Delete")
    void deleteRegisteredUserTest() {
        String response = step("Запрос на удаление зарегистрированного пользователя", () ->
                given(baseRequestSpecification)
                        .when()
                        .delete(userPath + newRegisteredUserId)
                        .then()
                        .spec(baseResponseSpecification(204))
                        .extract().asString());
        step("Проверка запроса", () -> {
            assertEquals("", response, "Ответ: No Content");
        });
    }

    @Test
    @Tag("rest_api")
    @DisplayName("4. Регистрация пользователя: Post - Register - successful ")
    void postRegisterSuccessfulUserTest() {
        PostRegisterSuccessfulModel authData = new PostRegisterSuccessfulModel();
        authData.setEmail(userEmail);
        authData.setPassword(userPass);
        PostResponseRegisterSuccessfulModel response = step("Запрос на регистрацию нового пользователя", () ->
                given(baseRequestSpecification)
                        .body(authData)
                        .when()
                        .post(userRegister)
                        .then()
                        .spec(baseResponseSpecification(200))
                        .extract().as(PostResponseRegisterSuccessfulModel.class));

        step("Проверка запроса", () -> {
            assertEquals("4", response.getId());
            assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        });
    }

    @Test
    @Tag("rest_api")
    @DisplayName("5. Авторизация пользователя: Post - Login - successful")
    void postLoginSuccessfulUserTest() {
        LoginBodyModel authData = new LoginBodyModel();
        authData.setEmail(userEmail);
        authData.setPassword(userPassLogin);
        LoginResponseModel response = step("Запрос на авторизацию зарегистрированного пользователя", () ->
                given(baseRequestSpecification)
                        .body(authData)
                        .when()
                        .post(userLogin)
                        .then()
                        .spec(baseResponseSpecification(200))
                        .extract().as(LoginResponseModel.class));
        step("Проверка запроса", () ->{
                assertNotEquals(null,response.getToken());
                assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
        });
    }

    @Test
    @Tag("rest_api")
    @DisplayName("6. Обновление значений параметров зарегистрированного пользователя: Put - Update")
    void updatingUsersInfoTest() {
        DataBodyLombokModel bodyDate = new DataBodyLombokModel("Inna Tyulyaeva_1", "1990", "QA_1");
        DataResponseModel response = step("Запрос на обновление значений параметров зарегистрированного пользователя", () ->
                given(baseRequestSpecification)
                        .body(bodyDate)
                        .when()
                        .put(userPath + newRegisteredUserId)
                        .then()
                        .spec(baseResponseSpecification(200))
                        .extract().as(DataResponseModel.class));
        step("Проверка запроса", () -> {
            assertEquals("Inna Tyulyaeva_1", response.getName());
            assertEquals("1990", response.getYear());
            assertEquals("QA_1", response.getJob());
        });
    }

    @Test
    @Tag("rest_api")
    @DisplayName("7. Обновление значений параметров зарегистрированного пользователя: Patch - Update")
    void patchingUsersJobTest() {
        DataBodyLombokModel bodyDate = new DataBodyLombokModel("","1992","");
        DataResponseModel response = step("Запрос на обновление значений параметров зарегистрированного пользователя", () ->
                given(baseRequestSpecification)
                        .body(bodyDate)
                        .when()
                        .patch(userPath + newRegisteredUserId)
                        .then()
                        .spec(baseResponseSpecification(200))
                        .extract().as(DataResponseModel.class));
        step("Проверка запроса", () -> {
            assertEquals("1992", response.getYear());
        });
    }
}
