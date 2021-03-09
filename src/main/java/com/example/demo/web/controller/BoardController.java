package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.common.dto.ResponseData;
import com.example.demo.common.dto.ResponseMessage;
import com.example.demo.web.entity.Board;
import com.example.demo.web.service.BoardService;
import com.example.demo.web.service.dto.BoardReqeustDto;
import com.example.demo.web.service.dto.BoardResponseDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;
import com.example.demo.web.service.dto.BoardUpdateRequestDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    
    private final BoardService boardService;

    // select
    @GetMapping("/all")
    public List<Board> getBoardListAll(){
        return boardService.getBoardListAll();
    }

    // http://localhost:8080/api/board/5
    @GetMapping("/{bNo}")
    public Board getBoard(@PathVariable(name = "bNo") Long id){
        return boardService.getBoardById(id);
    }

    // http://localhost:8080/api/board?page=1&size=10&sort=desc
    @GetMapping("")
    public Page<BoardResponseDto> getBoardList(BoardReqeustDto boardReqeustDto){
       Pageable pageable = PageRequest.of(boardReqeustDto.getPage(), 
                                          boardReqeustDto.getSize(),
                                          boardReqeustDto.getSort());

       return boardService.getBoardList(pageable);
    }
    
    // update
    @PutMapping("")
    public BoardResponseDto updateBoard(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        return boardService.update(boardUpdateRequestDto);
    }

    // insert
    @PostMapping("")
    public BoardResponseDto insertBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return boardService.insert(boardSaveRequestDto);
    }


}
