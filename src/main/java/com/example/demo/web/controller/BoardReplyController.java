package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.web.entity.BoardReply;
import com.example.demo.web.service.BoardReplyService;
import com.example.demo.web.service.dto.BoardReplySaveRequestDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board/reply")
public class BoardReplyController {
    
    private final BoardReplyService boardReplyService;

    @PostMapping("/insert")
    public BoardReply insertBoardReply(BoardReplySaveRequestDto dto){
        return boardReplyService.save(dto);
    }

    @GetMapping("/all")
    public List<BoardReply> getBoardReplyList(){
        return boardReplyService.findAll();
    }
}
