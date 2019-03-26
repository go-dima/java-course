package com.beans;

import com.aop.TimestampAnnotation;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
@Primary
public class PrototypeBean {
    public int x = (int)(Math.random()*100);

    @PostConstruct
    public void init(){
        System.out.printf("Prototype: %d\n", x);
    }

    @TimestampAnnotation
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
