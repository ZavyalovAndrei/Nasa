import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Main {

    private static final String KEY = "IwCmfHKTRY3vwRfSatr5Eah4jV4wjOb4Voe6LkVw";
    private static final String LINK = "https://api.nasa.gov/planetary/apod?api_key=";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("com.zavyalov")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build()) {
            HttpGet request = new HttpGet(LINK + KEY);
            request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
            CloseableHttpResponse response = httpClient.execute(request);
            NasaAnswer nasaData = mapper.readValue(response.getEntity().getContent(),
                    new TypeReference<NasaAnswer>() {
                    }
            );
            downloadFile(nasaData.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadFile(String urlStr) {
        try {
            URL url = new URL(urlStr);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            String[] link = url.getPath().split("/");
            String fileName = link[link.length - 1];
            FileOutputStream fis = new FileOutputStream(fileName);
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fis.write(buffer, 0, count);
            }
            System.out.println("File \"" + fileName + "\" saved.");
            fis.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}