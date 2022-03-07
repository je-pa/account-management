package com.cmt.cmt_eyes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserListPagingDto {
    private int page;
    private int limit;

    private Integer userSortId;
    private String company;

    public int getStartIdx(){
        return limit *(page-1);
    }
}
