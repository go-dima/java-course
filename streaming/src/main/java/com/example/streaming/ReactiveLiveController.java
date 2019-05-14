package com.example.streaming;

import com.example.streaming.beans.HobbitFlux;
import com.example.streaming.beans.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
public class ReactiveLiveController {

    @Autowired
    private HobbitFlux hobbit;

    @GetMapping(value="read/from/last", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> joinStream(){
        return hobbit.getHobbitLive();
    }

    @GetMapping(value="read/last", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readLast3(){
        return hobbit.getHobbitLive().take(3);
    }
}
