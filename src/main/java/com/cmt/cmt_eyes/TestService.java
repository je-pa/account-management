package com.cmt.cmt_eyes;

import com.cmt.cmt_eyes.entity.TestEntity;
import com.cmt.cmt_eyes.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestService {
    @Autowired public TestRepository testRepository;

    public List<TestEntity> selTest(){
        return testRepository.allTest();
    }
}
