package com.example.demo.web.service.dto;

import com.example.demo.web.entity.Board;

import lombok.Builder;
import lombok.Getter;

/**
 * @author        gun
 */
@Getter
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private String author = "admin";

    @Builder
    public BoardSaveRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder()
                    .title(title)
                    .content(content)
                    .author(author)
                    .build();
    }
}
