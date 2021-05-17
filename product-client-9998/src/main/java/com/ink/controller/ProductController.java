package com.ink.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MT
 * @date 2021/5/17 14:20
 */
@Slf4j
@RestController
public class ProductController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/product/getMsg")
    public String getMsg() {
        log.info("进入商品服务……端口：[{}]", port);
        return "进入商品服务……端口：[" + port + "]";
    }
}
