package apache;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class DeleteBoard {

    @Test
    public void DeleteBoardTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpDelete request = new HttpDelete("https://api.trello.com/1/boards/653b81f35cc7faf7d392c656?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC");

            CloseableHttpResponse response = httpClient.execute(request);

            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Status code: ");
            Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
            System.out.println("Response Status Code: " + response.getStatusLine().getStatusCode());

        } finally {
            httpClient.close();
        }
    }
}