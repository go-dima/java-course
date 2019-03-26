package com.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Primary
public class PrototypeBean {
    public int x = (int)(Math.random()*100);

//    @PostConstruct
//    public void init(){
//        System.out.printf("Prototype: %d\n", x);
//    }
}
