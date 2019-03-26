package com;

import com.beans.Person;
import com.beans.PrototypeBean;
import com.beans.SingletonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Test.class);

        PrototypeBean pb1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean pb2 = ctx.getBean("proto6", PrototypeBean.class);
        SingletonBean sb1 = ctx.getBean(SingletonBean.class);
        SingletonBean sb2 = ctx.getBean(SingletonBean.class);

        System.out.println("Proto: " + pb1.x);
        System.out.println("Proto: " + pb2.x);
        System.out.println("Single: " + sb1.x);
        System.out.println("Single: " + sb2.x);

        Person p = ctx.getBean(Person.class);
        p.setName("sss");
        System.out.println(p.toString());
        System.out.println(p);

        System.out.println("\nTimestamp annotations:");
        System.out.println("Expecting: annotation (method):");
        pb1.getX();
        System.out.println("-----");
        System.out.println("Expecting: no annotation (method):");
        pb1.setX(4);
        System.out.println("-----");
        System.out.println("Expecting annotation (class):");
        sb1.getX();
        System.out.println("-----");
        System.out.println("Expecting annotation (class):");
        sb1.setX(8);
        System.out.println("-----");
    }
}
