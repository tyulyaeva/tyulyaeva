package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import test.RestApi.TestBaseApi;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class RestApiSpec extends TestBaseApi {
    public static RequestSpecification baseRequestSpecification = with()
            .header(apiKeyName,apiKey)
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification baseResponseSpecification (int statusCode)
    {
        return new ResponseSpecBuilder()
            .expectStatusCode(statusCode)
            .log(STATUS)
            .log(BODY)
            .build();
    }
}