/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HelloService
 * Author:   zhangyong
 * Date:     2019/7/10 23:41
 * Description:
 * History:
 */
package cn.frochy.serviceribbon.service;

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

    public String hiService(String name) {
        return restTemplate.getForObject("http://" + providerName + "/hi?name=" + name, String.class);
    }
}
