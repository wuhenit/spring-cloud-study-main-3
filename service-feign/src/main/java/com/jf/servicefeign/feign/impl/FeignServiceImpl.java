package com.jf.servicefeign.feign.impl;

import com.jf.servicefeign.feign.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String getUserAndPort(String name) {
        return "Sorry" + name +"try again!";
    }
}
