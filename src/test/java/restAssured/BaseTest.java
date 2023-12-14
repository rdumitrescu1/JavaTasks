package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;


public class BaseTest {

    protected final static String BASE_URL = "https://api.trello.com/1/boards";
    protected final static String KEY = "ea47e302b77fcbdc6bc095d3c632d405";
    protected final static String TOKEN = "ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC";
    protected final static String CONTENT_TYPE = "application/json";


    protected RequestSpecification buildRequestSpecifications() {
        RequestSpecification requestSpec = RestAssured.given()
                .contentType(CONTENT_TYPE)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN);
        return requestSpec;
    }

    protected <T> RequestSpecification buildRequestSpecifications(T body) {
        RequestSpecification requestSpec = buildRequestSpecifications();
        requestSpec.body(body);
        return requestSpec;
    }

    protected Response sendPostRequest(Object body) {
        RequestSpecification requestSpecs = buildRequestSpecifications(body);
        return requestSpecs
                .when()
                .post(BASE_URL)
                .then()
                .extract()
                .response();
    }

    protected <T> Response sendPutRequest(String boardID, T bodyObject) {
        RequestSpecification requestSpecs = buildRequestSpecifications(bodyObject);
        String postUrl = BASE_URL + "/" + boardID;
        return requestSpecs
                .when()
                .put(postUrl)
                .then()
                .extract()
                .response();
    }

    protected Response sendGetRequest(String boardID) {
        RequestSpecification requestSpecs = buildRequestSpecifications();
        String getUrl = BASE_URL + "/" + boardID;
        return requestSpecs
                .when()
                .get(getUrl)
                .then()
                .extract()
                .response();

    }

    protected Response sendDeleteRequest(String boardID) {
        RequestSpecification requestSpecs = buildRequestSpecifications();
        String getUrl = BASE_URL + "/" + boardID;
        return requestSpecs
                .when()
                .delete(getUrl)
                .then()
                .extract()
                .response();
    }

    protected static void checkStatusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Expected status code 200");
    }
}
