package app;

import app.CopernicusHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SentinelDataController {

    private final CopernicusHttpClient copernicusHttpClient;

    public SentinelDataController(CopernicusHttpClient copernicusHttpClient) {
        this.copernicusHttpClient = copernicusHttpClient;
    }

    @GetMapping("/sentinel-data")
    public List<SentinelData> getSentinelData() throws IOException {
        SentinelData[] data = copernicusHttpClient.getSentinelData();
        return Arrays.stream(data).collect(Collectors.toList());
    }
}
