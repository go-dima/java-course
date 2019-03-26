package com.intercept;

import com.beans.PrototypeBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class EvenFilter implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PrototypeBean && !beanName.equals("proto6")) {
            PrototypeBean ins = (PrototypeBean)bean;
            if (ins.x % 2 != 0) {
                System.out.println("Updating " + ins.x + " to be even");
                ins.x++;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
