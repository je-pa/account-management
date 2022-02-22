package com.cmt.cmt_eyes.repository;

import com.cmt.cmt_eyes.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestRepository {
    List<TestEntity> allTest();
}
