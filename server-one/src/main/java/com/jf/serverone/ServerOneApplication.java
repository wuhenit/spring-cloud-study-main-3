package com.jf.serverone;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServerOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerOneApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Resource
    EurekaClient eurekaClient;

    @RequestMapping("/getString/{name}")
    public String getString(@PathVariable(value = "name") String name){
        //服务列表中的第一个服务的名称
        String serverName = eurekaClient.getApplications().getRegisteredApplications().get(0).getName();
        return name+"调用了服务.服务提供者有:"+serverName+"服务的端口是:"+port;
    }
}
