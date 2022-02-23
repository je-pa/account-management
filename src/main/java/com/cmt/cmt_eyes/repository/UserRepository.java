package com.cmt.cmt_eyes.repository;

import com.cmt.cmt_eyes.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    UserEntity[] allUser();
    UserEntity selUser(UserEntity param);

    UserEntity[] selUserList(UserEntity param);
}
