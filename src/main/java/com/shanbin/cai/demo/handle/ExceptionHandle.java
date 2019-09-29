package com.shanbin.cai.demo.handle;

import com.shanbin.cai.demo.domain.Result;
import com.shanbin.cai.demo.exception.GirlException;
import com.shanbin.cai.demo.service.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
