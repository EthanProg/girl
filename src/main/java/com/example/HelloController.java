package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liwenqing on 2017/1/20.
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private int age;
//
//    @Value("${content}")
//    private String content;

//    @Autowired
//    private GirlProperties girlProperties;
//
//    @RequestMapping(value = {"/hello", "hi"}, method = RequestMethod.GET)
//    public String say() {
//        return girlProperties.getCupSize();
//    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hi, host: " + instance.getHost() + ", service_id: " + instance.getServiceId());
        return "Hello World!";
    }
}
