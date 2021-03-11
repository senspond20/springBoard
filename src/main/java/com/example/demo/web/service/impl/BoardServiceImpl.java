package com.example.demo.web.service.impl;

import java.util.List;

import com.example.demo.web.entity.Board;
import com.example.demo.web.repository.BoardRepository;
import com.example.demo.web.service.BoardService;
import com.example.demo.web.service.dto.BoardResponseDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;
import com.example.demo.web.service.dto.BoardUpdateRequestDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * @author        gun
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public Board insert(BoardSaveRequestDto boardSaveRequestDto) {
        Board entity = boardRepository.save(boardSaveRequestDto.toEntity());
        return entity;
        // return new BoardResponseDto(entity);
    }

    @Override
    public Board update(BoardUpdateRequestDto boardUpdateRequestDto) {
        Long id = boardUpdateRequestDto.getId();
    	Board board = boardRepository.findById(id)
				                     .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
        return boardRepository.save(board);
        // return new BoardResponseDto(boardRepository.save(board));
    }

    @Override
    public List<Board> getBoardListAll() {
       return boardRepository.findAll();
    }

    @Override
    public Board getBoardById(Long id) {
        Board board = boardRepository.findById(id)
                                      .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return board;
    }

    @Override
    public Page<BoardResponseDto> getBoardList(Pageable pageable) {
        Page<Board> p = boardRepository.findAll(pageable);
		return p.map(item-> new BoardResponseDto(item));
    }


    
}
