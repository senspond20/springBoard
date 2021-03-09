package com.example.demo.web.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardUpdateRequestDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
