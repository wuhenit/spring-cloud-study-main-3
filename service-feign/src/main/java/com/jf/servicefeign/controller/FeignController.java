package com.jf.servicefeign.controller;

import com.jf.servicefeign.feign.FeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    FeignService feignService;

    @GetMapping(value = "/hello")
    public String getUserAndPort(@RequestParam String name){
        return feignService.getUserAndPort(name);
    }
}
