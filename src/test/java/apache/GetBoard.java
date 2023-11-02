package apache;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class GetBoard {

    @Test
    public void GetBoardTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet("https://api.trello.com/1/boards/65317fb4b8d4040685719396?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC");

            CloseableHttpResponse response = httpClient.execute(request);

            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Status code: ");
            Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        } finally {
            httpClient.close();
        }
    }
}