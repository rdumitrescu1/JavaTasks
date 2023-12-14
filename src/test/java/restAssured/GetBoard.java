package restAssured;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoClasses.Board;


public class GetBoard extends BaseTest {

    @Test
    public void GetBoardTest() {

        Response response = sendGetRequest("65324d421c4b3d39e647dc0c");
        Board actualResponse = response.as(Board.class);

        checkStatusCode(response, 200);
        Assertions.assertThat(actualResponse.getName()).isEqualTo("Razvan's board");
        Assertions.assertThat(actualResponse.getDesc()).isEqualTo("This board it's empty");
        Assert.assertNotNull(actualResponse, "Response body should not be null");

    }
}
