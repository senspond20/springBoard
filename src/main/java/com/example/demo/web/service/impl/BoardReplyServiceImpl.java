package com.example.demo.web.service.impl;

import java.util.List;

import com.example.demo.web.entity.BoardReply;
import com.example.demo.web.repository.BoardReplyRepository;
import com.example.demo.web.service.BoardReplyService;
import com.example.demo.web.service.dto.BoardReplySaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardReplyServiceImpl implements BoardReplyService{

    private final BoardReplyRepository boardReplyRepository;

 
    @Override
    public BoardReply save(BoardReplySaveRequestDto dto) {
        return boardReplyRepository.save(dto.toEntity());
    }

    @Override
    public List<BoardReply> findAll() {
        return boardReplyRepository.findAll();
    }

    // @Override
    public List<BoardReply> findByBoard_id(Long board_id) {
        // return boardReplyRepository.findByBoard_id(board_id);
        return null;
    }


    
}
