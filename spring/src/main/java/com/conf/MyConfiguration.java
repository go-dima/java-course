package com.conf;

import com.beans.PrototypeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public PrototypeBean proto6(){
        PrototypeBean p =new PrototypeBean();
        p.x = 6;
        return p;
    }
}
