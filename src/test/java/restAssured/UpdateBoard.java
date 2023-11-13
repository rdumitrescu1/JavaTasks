package restAssured;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import pojoClasses.Board;
import org.testng.annotations.Test;


public class UpdateBoard extends BaseTest {

    @Test
    public void UpdateBoardTest() {

        Board newBoard = new Board("Updated Board with put", "This is updated with put", "651be0cea5cb14826012f007");
        String body = convertObjectToJson(newBoard);

        Response response = sendPutRequest("Dccffdjo", body);
        Board actualResponse = convertJsonToObject(response);

        checkStatusCode(response, 200);
        Assertions.assertThat(actualResponse.getName()).isEqualTo("Updated Board with put");
        Assertions.assertThat(actualResponse.getDesc()).isEqualTo("This is updated with put");
        Assert.assertNotNull(actualResponse, "Response body should not be null");

    }

}
