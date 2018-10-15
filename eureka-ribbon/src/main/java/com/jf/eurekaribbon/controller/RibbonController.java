package com.jf.eurekaribbon.controller;

import com.jf.eurekaribbon.service.RibbonService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
public class RibbonController {

    @Resource
    RibbonService ribbonService;

    @RequestMapping(value = "/getStr/{name}")
    public String getStrings(@PathVariable("name") String name){
        return ribbonService.getStrings(name);
    }
}
