package com.imooc.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @RequestMapping("/msg")
    public String msg(){
        return "this is server.";
    }
}
