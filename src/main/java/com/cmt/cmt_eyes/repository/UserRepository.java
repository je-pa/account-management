package com.cmt.cmt_eyes.repository;

import com.cmt.cmt_eyes.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserEntity[] allUser();
    UserEntity selUser(UserEntity param);

    UserEntity[] selUserList(UserEntity param);


    int approvalUser(UserEntity param);
    int updatePw(UserEntity param);
}
