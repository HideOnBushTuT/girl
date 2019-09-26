package com.shanbin.cai.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private GirlConfiguration girlConfiguration;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return girlConfiguration.getCupSize();
    }

}
