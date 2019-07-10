/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HelloController
 * Author:   zhangyong
 * Date:     2019/7/10 23:43
 * Description:
 * History:
 */
package cn.frochy.serviceribbon.controller;

import cn.frochy.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈func〉<br>
 * 〈〉
 *
 * @author zhangyong
 * @create 2019/7/10
 * @since 1.0.0
 */

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(String name) {
        return helloService.hiService(name);
    }
}
