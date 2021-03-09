package com.example.demo.web.service.dto;

import com.example.demo.web.entity.Board;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardSaveRequestDto {
    private String title;
    private String content;

    @Builder
    public BoardSaveRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity(String author){
        return Board.builder()
                    .title(title)
                    .content(content)
                    .author(author)
                    .build();
    }
}
