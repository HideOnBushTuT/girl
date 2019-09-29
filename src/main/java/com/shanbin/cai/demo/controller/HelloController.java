package com.shanbin.cai.demo.controller;

import com.shanbin.cai.demo.props.GirlConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("helloController")
public class HelloController {

    @Autowired
    private GirlConfiguration girlConfiguration;

//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return girlConfiguration.getCupSize() + myId;
    }

}
