package cn.frochy.servicefeign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHytrix implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hi, "+name+", sorry, error!";
    }
}
