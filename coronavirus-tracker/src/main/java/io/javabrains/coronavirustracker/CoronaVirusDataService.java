package io.javabrains.coronavirustracker;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest

@Service
public class CoronaVirusDataService {
     private static final String VIRUS_DATA_URL =  " "

    @PostConstruct
     public void fetchVirusData() throws IOException, InterruptedException {
       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HtttpRequest.newBuilder()
               .uri(URI.create(VIRUS_DATA_URL))
               .build();
       HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            String State = record.get("Province/State");
            System.out.println(state);

        }
    }
}
