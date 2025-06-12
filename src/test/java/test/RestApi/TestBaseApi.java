package test.RestApi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {
    protected static final String userPath= "/users/";
    protected static final String userLogin = "/login";
    protected static final String apiKey =  "reqres-free-v1";

    protected static final String apiKeyName = "x-api-key";
    protected static final String userRegister = "/register";
    protected static final String userPass = "pistol";
    protected static final String userEmail = "eve.holt@reqres.in";
    protected static final String userPassLogin = "cityslicka";

    @BeforeAll
    static void setupConfig() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }
}
