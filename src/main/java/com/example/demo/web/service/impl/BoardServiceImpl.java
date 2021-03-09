package com.example.demo.web.service.impl;

import com.example.demo.web.entity.Board;
import com.example.demo.web.service.BoardService;
import com.example.demo.web.service.dto.BoardSaveRequestDto;
import com.example.demo.web.service.dto.BoardUpdateRequestDto;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public class BoardServiceImpl implements BoardService{

    @Override
    public Long insert(BoardSaveRequestDto boardSaveRequestDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long update(BoardUpdateRequestDto boardUpdateRequestDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Board getBoardById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Board> getBoardList(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
