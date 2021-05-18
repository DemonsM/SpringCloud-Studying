package com.ink.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author MT
 * @date 2021/5/17 16:04
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {
    private static final String PRODUCT_URL = "http://product-client/product/getMsg";
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;
    private final LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/showProduct")
    public String showProduct() {
        log.info("用户服务调用商品服务……");
        //RestTemplate 调用
        /*RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject(PRODUCT_URL, String.class);*/
        //获取某个服务的所有实例
        //List<ServiceInstance> instances = discoveryClient.getInstances("product-client");
        //负载均衡获取某个服务中的一个服务实例
        //ServiceInstance choose = loadBalancerClient.choose("product-client");
        return restTemplate.getForObject(PRODUCT_URL, String.class);
    }
}
