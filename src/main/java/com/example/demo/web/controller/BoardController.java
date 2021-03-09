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
import org.springframework.lang.Nullable;
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

    @GetMapping("/all")
    public List<Board> getBoardListAll(){
        return boardService.getBoardListAll();
    }

    @GetMapping("/{bNo}")
    public BoardResponseDto getBoard(@PathVariable(name = "bNo") Long id){
        return boardService.getBoardById(id);
    }

    // http://localhost:8080/api/board/paging?page=1&size=10&sort=desc
    @GetMapping("/paging")
    public Page<BoardResponseDto> getBoardList(BoardReqeustDto boardReqeustDto){

    //    if(boardReqeustDto == null){
    //        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
    //        return boardService.getBoardList(pageable);
    //    }
       Pageable pageable = PageRequest.of(boardReqeustDto.getPage(), 
                                          boardReqeustDto.getSize(),
                                          boardReqeustDto.getSort());

       return boardService.getBoardList(pageable);
    }

    @PutMapping("")
    public Long updateBoard(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        return boardService.update(boardUpdateRequestDto);
    }

    @PostMapping("")
    public BoardResponseDto insertBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return boardService.insert(boardSaveRequestDto);
    }


}
