package com.example.demo.web.service.dto;

import lombok.Getter;

/**
 * @author        gun
 */
@Getter
public class BoardReqeustDto {
    private int page;
    private int size;
    private String sort;

    public BoardReqeustDto(int page, int size, String sort){
//  this.page = (page == 0 ) ? 0 : page - 1; // pageable 기본적으로 zero Index
//  => PageableHandlerMethodArgumentResolverCustomizer 로 page index를 1페이지부터 재정의
        this.page = page;
        this.size = size;
        this.sort = sort; 
    }
}
