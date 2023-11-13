package restAssured;

import io.restassured.response.Response;
import org.testng.annotations.Test;


public class DeleteBoard extends BaseTest {

    @Test
    public void DeleteBoardTest() {

        Response response = sendDeleteRequest("stDDuRn8");
        checkStatusCode(response, 200);
    }
}
