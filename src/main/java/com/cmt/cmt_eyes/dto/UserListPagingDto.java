package com.cmt.cmt_eyes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserListPagingDto extends UserDto{
    private int page; //참조형//////
    private int limit;

    private String search;

    private String loginUserSort;

    public int getStartIdx(){
        return limit *(page-1);
    }
}
