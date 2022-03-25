package com.cmt.cmt_eyes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto {
    private int pageCount;
    private int currentPage;
    private final int PAGE_LINK_COUNT = 10;
    public int getCurrentFirstCountPage() {
        if(currentPage%10==0){
            return currentPage-10+1;
        }
        return currentPage-currentPage%10+1;
    }

    public int getCurrentLastCountPage() {
        if(currentPage%10==0){
            return currentPage;
        }
        int currentLastPage = currentPage-currentPage%10+10;
        return currentLastPage > pageCount ? pageCount : currentLastPage;
    }
}
