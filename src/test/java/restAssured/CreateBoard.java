package restAssured;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoClasses.Board;



public class CreateBoard extends BaseTest {

    @Test
    public void CreateBoardTest() {

        Board newBoard = new Board("Board by RestAssured", "This is created by using RestAssured", "651be0cea5cb14826012f007");

        Response response = sendPostRequest(newBoard);
        Board actualResponse = response.as(Board.class);

        checkStatusCode(response, 200);
        Assertions.assertThat(actualResponse.getName()).isEqualTo("Board by RestAssured");
        Assertions.assertThat(actualResponse.getDesc()).isEqualTo("This is created by using RestAssured");
        Assert.assertNotNull(actualResponse, "Response body should not be null");

    }
}

