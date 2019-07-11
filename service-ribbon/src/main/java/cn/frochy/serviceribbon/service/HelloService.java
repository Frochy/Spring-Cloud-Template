/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HelloService
 * Author:   zhangyong
 * Date:     2019/7/10 23:41
 * Description:
 * History:
 */
package cn.frochy.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 〈func〉<br>
 * 〈〉
 *
 * @author zhangyong
 * @create 2019/7/10
 * @since 1.0.0
 */
@Service
public class HelloService {

    @Value("${provider.name}")
    private String providerName;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * HystrixCommand create hytrix , parameter fallbackMethod mark the method
     * will be used when the provider is crashed.
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "errorFallback")
    public String hiService(String name) {
        return restTemplate.getForObject("http://" + providerName + "/hi?name=" + name, String.class);
    }

    // fallback method
    public String errorFallback(String name){
        return "hi, "+name+", sorry, error!";
    }
}
