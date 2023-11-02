package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetBoard {

    @Test
    public void GetBoardTest() {

        Response response =
                RestAssured
                        .given()
                        .contentType("application/json")
                        .when()
                        .get("https://api.trello.com/1/boards/65324dd2d022895080ebd707?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC")
                        .then()
                        //.log().all()
                        .extract()
                        .response();

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        Assert.assertNotNull(response.getBody().asString(), "Response body should not be null");
        Assert.assertTrue(response.getBody().asString().contains("Board by apache"));

    }
}

