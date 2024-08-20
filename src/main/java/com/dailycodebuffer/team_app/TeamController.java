package com.dailycodebuffer.team_app;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Log4j2
public class TeamController {

    private RestClient restClient;

    public TeamController(RestClient.Builder builder){
        this.restClient =
                builder.baseUrl("http://localhost:8090")
                .build();
    }

    @GetMapping("/")
    public List<String> getPlayersForTeam() {
        log.info("Running on {}", Thread.currentThread());

        return restClient.get()
                .uri("/players")
                .retrieve()
                .toEntity(List.class).getBody();
    }
}