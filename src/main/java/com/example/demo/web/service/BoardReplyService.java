package com.example.demo.web.service;

import java.util.List;

import com.example.demo.web.entity.BoardReply;
import com.example.demo.web.service.dto.BoardReplySaveRequestDto;

public interface BoardReplyService {
    
    BoardReply save(BoardReplySaveRequestDto dto);
    List<BoardReply> findAll();

    // List<BoardReply> findByBoard_id(Long board_id);
}
