package com.shanbin.cai.demo.service;

import com.shanbin.cai.demo.ResultEnum;
import com.shanbin.cai.demo.exception.GirlException;
import com.shanbin.cai.demo.repo.GirlRepo;
import com.shanbin.cai.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepo girlRepo;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCpuSize("B");
        girlA.setAge(20);
        girlRepo.save(girlA);

        Girl girlB = new Girl();
        girlB.setCpuSize("A");
        girlB.setAge(22);
        girlRepo.save(girlB);
    }


    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepo.findById(id).get();
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //
    }

}
