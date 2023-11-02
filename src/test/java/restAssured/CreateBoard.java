package restAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoClasses.Board;


public class CreateBoard {

    @Test
    public void CreateBoardTest() {
        try {
            Board newBoard = new Board("Board by RestAssured", "This is created by using RestAssured", "651be0cea5cb14826012f007");

            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(newBoard);

            Response response =
                    RestAssured
                            .given()
                            .contentType("application/json")
                            .body(body)
                            .when()
                            .post("https://api.trello.com/1/boards?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC")
                            .then()
                            //   .log().all()
                            .extract()
                            .response();

            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
            Assert.assertNotNull(response.getBody().asString(), "Response body should not be null");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
