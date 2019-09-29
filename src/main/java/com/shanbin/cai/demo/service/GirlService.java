package com.shanbin.cai.demo.service;

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


}
