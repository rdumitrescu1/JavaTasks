package apache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoClasses.Board;
import java.io.IOException;


public class UpdateBoard {

    @Test
    public void UpdateBoardTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpPut put = new HttpPut("https://api.trello.com/1/boards/653b81f35cc7faf7d392c656?key=ea47e302b77fcbdc6bc095d3c632d405&token=ATTAdac1df17c5d268b1c8eef82325adc4867cd342c5c51f5963d9b9af68fffc89d8454F54BC");

            Board newBoard = new Board("Updated Board using apache", "Updated with put", "651be0cea5cb14826012f007");
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(newBoard);

            StringEntity stringEntity = new StringEntity(body, ContentType.APPLICATION_JSON);
            put.setEntity(stringEntity);

            CloseableHttpResponse response = httpClient.execute(put);

            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Status code: ");
            Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            System.out.println(result);

        } finally {
            httpClient.close();
        }
    }
}


