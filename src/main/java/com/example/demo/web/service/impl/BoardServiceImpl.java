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
    public BoardResponseDto insert(BoardSaveRequestDto boardSaveRequestDto) {
        Board entity = boardRepository.save(boardSaveRequestDto.toEntity());
        return new BoardResponseDto(entity);
    }

    @Override
    public Long update(BoardUpdateRequestDto boardUpdateRequestDto) {
        Long id = boardUpdateRequestDto.getId();
    	Board board = boardRepository.findById(id)
				                     .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
        return id;
    }

    @Override
    public List<Board> getBoardListAll() {
       return boardRepository.findAll();
    }

    @Override
    public BoardResponseDto getBoardById(Long id) {
        Board entity = boardRepository.findById(id)
                                      .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new BoardResponseDto(entity);
    }

    @Override
    public Page<BoardResponseDto> getBoardList(Pageable pageable) {
    
        //int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
		//pageable = PageRequest.of(page, (int) pageable.getOffset(), Sort.by("id").descending());

		// pageable.getOffset() 기본 20
        Page<Board> p = boardRepository.findAll(pageable);
		return p.map(item-> new BoardResponseDto(item));
    }


    
}
