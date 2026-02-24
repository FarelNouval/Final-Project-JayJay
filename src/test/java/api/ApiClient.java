package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    private static final String BASE_URL = "https://dummyapi.io/data/v1";
    private static final String APP_ID = "63a804408eb0cb069b57e43a";

    public static RequestSpecification request() {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .contentType("application/json");
    }
}