package restAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojoClasses.Board;


public class BaseTest {

    protected final String baseUrl = "https://api.trello.com/1/boards";
    protected final String key = "ea47e302b77fcbdc6bc095d3c632d405";
    protected final String token = "ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC";
    protected final String contentType = "application/json";

    ObjectMapper objectMapper = new ObjectMapper();

    protected String convertObjectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected RequestSpecification buildRequestSpecifications(String body) {
        RequestSpecification requestSpec = RestAssured.given()
                .contentType(contentType)
                .queryParam("key", key)
                .queryParam("token", token);
        if (body != null) {
            requestSpec.body(body);
        }

        return requestSpec;
    }

    protected Response sendPostRequest(String body) {
        RequestSpecification requestSpecs = buildRequestSpecifications(body);
        return requestSpecs
                .when()
                .post(baseUrl)
                .then()
                .extract()
                .response();
    }

    protected Response sendPutRequest(String boardID, String body) {
        RequestSpecification requestSpecs = buildRequestSpecifications(body);
        String postUrl = baseUrl + "/" + boardID;
        return requestSpecs
                .when()
                .put(postUrl)
                .then()
                .extract()
                .response();
    }

    protected Response sendGetRequest(String boardID) {
        RequestSpecification requestSpecs = buildRequestSpecifications(null);
        String getUrl = baseUrl + "/" + boardID;
        return requestSpecs
                .when()
                .get(getUrl)
                .then()
                .extract()
                .response();

    }

    protected Response sendDeleteRequest(String boardID) {
        RequestSpecification requestSpecs = buildRequestSpecifications(null);
        String getUrl = baseUrl + "/" + boardID;
        return requestSpecs
                .when()
                .delete(getUrl)
                .then()
                .extract()
                .response();
    }

    protected Board convertJsonToObject(Response response) {
        try {
            return objectMapper.readValue(response.getBody().asString(), Board.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected static void checkStatusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Expected status code 200");
    }
}
