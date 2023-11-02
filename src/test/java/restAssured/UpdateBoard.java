package restAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoClasses.Board;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class UpdateBoard {

    @Test
    public void UpdateBoardTest() {
        try {
            Board newBoard = new Board("Updated Board with put", "This is updated with put", "651be0cea5cb14826012f007");

            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(newBoard);

            Response response =
                    RestAssured
                            .given()
                            .contentType("application/json")
                            .body(body)
                            .when()
                            .put("https://api.trello.com/1/boards/653b817682ca872597cbf596?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC")
                            .then()
                            //.log().all()
                            .extract()
                            .response();

            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            assertThat(response.getStatusCode()).as("Status code should be 200").isEqualTo(200);
            assertThat(response.getBody().asString()).as("Response body should not be null").isNotNull();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}