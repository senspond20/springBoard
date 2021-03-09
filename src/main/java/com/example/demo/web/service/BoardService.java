package com.example.demo.web.service;

import com.example.demo.web.service.dto.BoardResponseDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;
import com.example.demo.web.service.dto.BoardUpdateRequestDto;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface BoardService {
    
    Long insert(BoardSaveRequestDto boardSaveRequestDto);
    
    Long update(BoardUpdateRequestDto boardUpdateRequestDto);
    
    BoardResponseDto getBoardById(Long id);

    Page<BoardResponseDto> getBoardList(Pageable pageable);
}
