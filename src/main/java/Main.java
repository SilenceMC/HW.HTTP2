import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {


    public static ObjectMapper mapper = new ObjectMapper();

    public static void downloadFile(URL url, String fileName) throws IOException {
        FileUtils.copyURLToFile(url, new File(fileName));
    }

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=atV56CidxZmeAQ6YHERi2adNAzIG2M5ACzua480J");
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        NasaResponse nasaResponse = mapper.readValue(
                response.getEntity().getContent(), new
                        TypeReference<>() {
                        });


        String fileName = nasaResponse.getTitle() + ".jpg";

        downloadFile(nasaResponse.getHdurl(),fileName);
    }
}
