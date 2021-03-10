package com.example.demo.web.service.dto;

import com.example.demo.web.entity.BoardReply;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardReplySaveRequestDto {
    private Long board_id;
    private String replyContent;

    @Builder
    public BoardReplySaveRequestDto(Long board_id, String replyContent){
        this.board_id = board_id;
        this.replyContent = replyContent;
    }

    public BoardReply toEntity() {
        return BoardReply.builder()
                         .board_id(board_id)
                         .reply(replyContent)
                         .build();
    }
}
