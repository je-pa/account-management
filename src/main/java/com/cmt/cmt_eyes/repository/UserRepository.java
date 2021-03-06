package com.cmt.cmt_eyes.repository;

import com.cmt.cmt_eyes.dto.PageDto;
import com.cmt.cmt_eyes.dto.UserDto;
import com.cmt.cmt_eyes.dto.UserListPagingDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    int createUser(UserDto param);

    UserDto[] allUser();
    UserDto loginUser(UserDto param);
    UserDto selUser(UserDto param);

    UserDto[] selUserList(UserListPagingDto param);
    UserDto[] selCompanyList();

    PageDto countPage(UserListPagingDto param);

    int approvalUser(UserDto param);
    int updatePw(UserDto param);
}
