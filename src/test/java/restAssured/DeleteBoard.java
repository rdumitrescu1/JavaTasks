package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeleteBoard {

    @Test
    public void DeleteBoardTest() {

        Response response =
                RestAssured
                        .given()
                        .contentType("application/json")
                        .when()
                        .delete("https://api.trello.com/1/boards/653b817682ca872597cbf596?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC")
                        .then()
                        .extract()
                        .response();

        System.out.println("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");


    }
}

