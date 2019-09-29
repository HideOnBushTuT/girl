package com.shanbin.cai.demo.repo;

import com.shanbin.cai.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepo extends JpaRepository<Girl, Integer> {

}
