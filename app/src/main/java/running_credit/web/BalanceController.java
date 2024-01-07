package running_credit.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class BalanceController {

    public final WebClient webClient;

    public BalanceController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/sources")
    public ResponseEntity<DataSources> sources() {
        return this.webClient.get()
                .uri("https://www.googleapis.com/fitness/v1/users/me/dataSources")
                .retrieve()
                .toEntity(DataSources.class)
                .block();
    }

    public record DataSources(List<DataSource> dataSource) {}
    public record DataSource(String dataStreamId) {}
}
