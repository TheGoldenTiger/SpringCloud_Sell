package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    //超时配置
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
//    @HystrixCommand(commandProperties = {
//        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                //设置熔断
//        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
//        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
//        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),    //错误率
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.postForObject("http://localhost:8081/product/listForOrder",
                Arrays.asList("123457"),
                String.class);
//        throw new RuntimeException("发送异常了");
    }
    private String fallback(){
        return "太拥挤了,请稍后再试~~~~~~~";
    }
    private String defaultFallback(){
        return "默认提示：太拥挤了,请稍后再试~~~~~~~";
    }
}
