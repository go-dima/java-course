package com.example.userservice.springuserservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/userservice")
    public String userService() {
        // http://localhost:8001/userservice
        return "User Service";
    }

    @HystrixCommand(fallbackMethod = "fallback",
                    groupKey = "userservice",
                    commandKey = "userservice",
                    threadPoolKey = "userserviceThread")
    @GetMapping("/userservice/pay")
    public String Pay() {
        // http://localhost:8001/userservice/pay
        String url = "http://payment-service/paymentservice";
        return restTemplate.getForObject(url, String.class) + " from UserService /userservice/pay";
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fallback - No available payment-service instances";
    }
}
