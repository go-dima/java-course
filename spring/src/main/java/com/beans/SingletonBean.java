package com.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class SingletonBean {
    public int x = (int)(Math.random()*100);

    @Getter
    @Setter
    private String test;

//    @PostConstruct
    public void init(){
        System.out.printf("Singleton: %d\n", x);
    }
}
