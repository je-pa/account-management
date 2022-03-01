package com.cmt.cmt_eyes.repository;

import com.cmt.cmt_eyes.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserDto[] allUser();
    UserDto loginUser(UserDto param);
    UserDto selUser(UserDto param);

    UserDto[] selUserList(UserDto param);
    UserDto[] selCompanyList();

    int approvalUser(UserDto param);
    int updatePw(UserDto param);
}
