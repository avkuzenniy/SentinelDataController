package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CopernicusHttpClient {

    private final String baseUrl = "https://apihub.copernicus.eu/apihub/odata/v1";

    private final CloseableHttpClient httpClient;

    public CopernicusHttpClient() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("oleksandr79", "cdtnkjdjlcrA1"));

        this.httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
    }

    public SentinelData[] getSentinelData() throws IOException {
        HttpGet request = new HttpGet(baseUrl + "/Products?$filter=Name%20eq%20%27S3B_OL_2_LFR____20220109T035415_20220109T035715_20220110T080326_0179_061_175_3780_LN1_O_NT_002%27&$format=json");
        request.setHeader(HttpHeaders.ACCEPT, "application/json");

        CloseableHttpResponse response = httpClient.execute(request);
        String json = new String(String.valueOf(response.getEntity().getContent().read()));

        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();
        SentinelData[] data = objectMapper.readValue(json, SentinelData[].class);

        return data;
    }
}
