package com.example.streaming.beans;

import org.springframework.stereotype.Component;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
public class HobbitFlux {
    public Flux<Line> getHobbitVod() {
        return hobbitVod;
    }

    public ConnectableFlux<Line> getHobbitLive() {
        return hobbitLive;
    }

    private Flux<Line> hobbitVod;
    private ConnectableFlux<Line> hobbitLive;

    public HobbitFlux() throws URISyntaxException, IOException {
        URL hobbitResource = getClass().getClassLoader().getResource("Hobbit.txt");
        List<String> data = Files.readAllLines(Paths.get(hobbitResource.toURI()));
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            lines.add(new Line(i+1, data.get(i)));
        }
        hobbitVod = Flux.fromIterable(lines);
        hobbitLive = hobbitVod.delayElements(Duration.ofSeconds(3)).replay(3);
        hobbitLive.connect();
    }
}
