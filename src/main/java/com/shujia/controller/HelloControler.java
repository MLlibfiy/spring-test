package com.shujia.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解：相当于给这个类加了一个标记
 *
 */
@RestController
public class HelloControler {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloSpringBoot(){
        return "Hello SpringBoot!";
    }
}
