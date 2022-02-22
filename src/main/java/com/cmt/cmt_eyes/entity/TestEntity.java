package com.cmt.cmt_eyes.entity;

import lombok.*;
@Getter
@Setter
@ToString
public class TestEntity {
    private int testNum;
    private String name;

    public int getTestNum() {
        return testNum;
    }

    public String getName() {
        return name;
    }
}
