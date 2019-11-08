package com.shanbin.cai.demo.controller;

import com.shanbin.cai.demo.domain.Result;
import com.shanbin.cai.demo.repo.GirlRepo;
import com.shanbin.cai.demo.domain.Girl;
import com.shanbin.cai.demo.service.GirlService;
import com.shanbin.cai.demo.service.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Year;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepo girlRepo;

    @Autowired
    private GirlService girlService;

    @ApiOperation(value = "获取全部女孩。", notes = "")
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepo.findAll();
    }

    @ApiOperation(value = "添加女孩", notes = "根据girl对象添加女孩")
    @ApiImplicitParam(name = "girl", value = "女孩实例", required = true, dataType = "Girl")
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        System.out.println(222222);
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(girl.getCpuSize());
        return ResultUtil.success(girlRepo.save(girl));
    }

    @ApiOperation(value = "查询单个女孩信息", notes = "根据ID来查询女孩信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
//    })
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return  girlRepo.findById(id).get();
    }


    @ApiOperation(value = "更新女孩信息", notes = "更新女孩信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "女孩ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "cupSize", value = "女孩 cupSize", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "girl's age", required = true, dataType = "Integer")
    })
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
