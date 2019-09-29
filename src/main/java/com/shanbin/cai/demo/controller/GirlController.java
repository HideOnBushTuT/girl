package com.shanbin.cai.demo.controller;

import com.shanbin.cai.demo.domain.Result;
import com.shanbin.cai.demo.repo.GirlRepo;
import com.shanbin.cai.demo.domain.Girl;
import com.shanbin.cai.demo.service.GirlService;
import com.shanbin.cai.demo.service.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepo girlRepo;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepo.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        System.out.println(222222);
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(girl.getCpuSize());
        return ResultUtil.success(girlRepo.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return  girlRepo.findById(id).get();
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCpuSize(cupSize);
        girl.setAge(age);

        return girlRepo.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepo.deleteById(id);
    }


    @PostMapping(value = "/girls/two")
    public void  girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/age/{id}")
    public void getGirlAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
