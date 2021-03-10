package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.web.entity.Board;
import com.example.demo.web.service.BoardService;
import com.example.demo.web.service.dto.BoardReqeustDto;
import com.example.demo.web.service.dto.BoardResponseDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;
import com.example.demo.web.service.dto.BoardUpdateRequestDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    
    private final BoardService boardService;

    
    // --------------  select -------------------

    @GetMapping("/all")
    public List<Board> getBoardListAll(){
        return boardService.getBoardListAll();
    }

    // http://localhost:8080/api/board/5
    @GetMapping("/{bNo}")
    public Board getBoardDetail(@PathVariable(name = "bNo") Long id){
        return boardService.getBoardById(id);
    }

    // http://localhost:8080/api/board?page=1&size=10&sort=desc
    @GetMapping("")
    public Page<BoardResponseDto> getBoardList(BoardReqeustDto boardReqeustDto){

       Sort sort = boardReqeustDto.getSort().toLowerCase().equals("asc") 
                    ? Sort.by("id").ascending() 
                    : Sort.by("id").descending();

       Pageable pageable = PageRequest.of(boardReqeustDto.getPage(), 
                                          boardReqeustDto.getSize(),
                                          sort);

       return boardService.getBoardList(pageable);
    }
    
    // --------------  update -------------------
    
    @PutMapping("/update")
    public BoardResponseDto updateBoard(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        return boardService.update(boardUpdateRequestDto);
    }

    // --------------  insert -------------------

    @PostMapping("/insert")
    public BoardResponseDto insertBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return boardService.insert(boardSaveRequestDto);
    }

    // --------------  delete -------------------
    
    @DeleteMapping("/delete")
    public void deleteBoard(Long id){
        
    }


}
