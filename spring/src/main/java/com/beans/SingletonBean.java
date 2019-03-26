package com.beans;

import com.aop.TimestampAnnotation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Lazy
@TimestampAnnotation
public class SingletonBean {
    public int x = (int)(Math.random()*100);

    @Getter
    @Setter
    private String test;

    @PostConstruct
    public void init(){
        System.out.printf("Singleton: %d\n", x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
