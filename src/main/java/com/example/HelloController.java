package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liwenqing on 2017/1/20.
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return content;
    }
}
