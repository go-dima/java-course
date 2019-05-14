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
public class ReactiveVodController {

    @Autowired
    private HobbitFlux hobbit;

    @GetMapping(value="read/line/{number}", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Line> readLine(@PathVariable("number")int line){
        return hobbit.getHobbitVod().elementAt(line-1);
    }

    @GetMapping(value="read/line/{number}/{words}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> readLine(@PathVariable("number")int lineNo, @PathVariable("words")int numOfWords){
        List<String> words=new ArrayList<>();
        hobbit.getHobbitVod().elementAt(lineNo-1).subscribe(line->{
            StringTokenizer tokens=new StringTokenizer(line.getContent()," ");
            for(int i=0;i<numOfWords&&tokens.hasMoreTokens();i++) {
                words.add(tokens.nextToken());
            }
        });
        return Flux.fromIterable(words);
    }

    @GetMapping(value="read/{lines}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readLines(@PathVariable("lines")long lines){
        return hobbit.getHobbitVod().take(lines);
    }

    @GetMapping(value="read/{from}/{to}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readLines(@PathVariable("from")long from,
                                @PathVariable("to")long to){
        return hobbit.getHobbitVod().skipWhile(line->line.getIndex()<from).takeUntil(line->line.getIndex()>=to);
    }

    @GetMapping(value="read/{from}/{to}/{delayMillis}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readLine(@PathVariable("from")long from,
                               @PathVariable("to")long to,
                               @PathVariable("delayMillis")long delayMillis){
        return readLines(from,to).delayElements(Duration.ofMillis(delayMillis));
    }

    @GetMapping(value="read/all/{delayMillis}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readAll(@PathVariable("delayMillis")long delayMillis){
        return hobbit.getHobbitVod().delayElements(Duration.ofMillis(delayMillis));
    }

    @GetMapping(value="read/until/{sec}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readUntil(@PathVariable("sec")long sec) {
        return hobbit.getHobbitVod().take(Duration.ofSeconds(sec));
    }
}
