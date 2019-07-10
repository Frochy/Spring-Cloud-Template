/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HelloController
 * Author:   zhangyong
 * Date:     2019/7/11 0:34
 * Description:
 * History:
 */
package cn.frochy.servicefeign.controller;

import cn.frochy.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈func〉<br>
 * 〈〉
 *
 * @author zhangyong
 * @create 2019/7/11
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    //called the service
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam(value = "name") String name) {

        return helloService.sayHello(name);
    }
}
