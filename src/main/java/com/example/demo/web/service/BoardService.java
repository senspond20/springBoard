package com.example.demo.web.service;

import java.util.List;

import com.example.demo.web.entity.Board;
import com.example.demo.web.service.dto.BoardResponseDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;
import com.example.demo.web.service.dto.BoardUpdateRequestDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author        gun
 */
public interface BoardService {
    
    BoardResponseDto insert(BoardSaveRequestDto boardSaveRequestDto);
    
    Long update(BoardUpdateRequestDto boardUpdateRequestDto);
    
    List<Board> getBoardListAll();

    BoardResponseDto getBoardById(Long id);

    Page<BoardResponseDto> getBoardList(Pageable pageable);
}
