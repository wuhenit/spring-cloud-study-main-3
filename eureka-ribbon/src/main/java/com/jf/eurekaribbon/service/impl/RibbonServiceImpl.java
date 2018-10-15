package com.jf.eurekaribbon.service.impl;

import com.jf.eurekaribbon.service.RibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl implements RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @Override
    public String getStrings(String name) {

        return restTemplate.getForObject("http://SERVER-ONE/getString/"+name,String.class);
    }

    @Override
    public String error(String name) {
        return "Sorry ,an error occurred on the server!";
    }
}
