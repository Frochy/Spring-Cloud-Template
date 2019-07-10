/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HelloService
 * Author:   zhangyong
 * Date:     2019/7/11 0:32
 * Description:
 * History:
 */
package cn.frochy.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 〈func〉<br>
 * 〈FeignClient annotation mark that
 * which service will be called〉
 *
 * @author zhangyong
 * @create 2019/7/11
 * @since 1.0.0
 */
@FeignClient(value = "service-hi")
public interface HelloService {
    //like a controller, but it's a none implementing function.
    @GetMapping(value = "/hi")
    String sayHello(@RequestParam(value = "name") String name);
}
