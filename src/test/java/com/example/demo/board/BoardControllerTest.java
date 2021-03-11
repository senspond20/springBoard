package com.example.demo.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.web.entity.Board;
import com.example.demo.web.service.BoardService;
import com.example.demo.web.service.dto.BoardResponseDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
// @DataJdbcTest
// @AutoConfigureTestDatabase(replace = Replace.NONE)
public class BoardControllerTest {
    
    // @Autowired
    // private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    public void test(){
        BoardSaveRequestDto dto = new BoardSaveRequestDto("제목입니다", "내용입니다.");
        boardService.insert(dto);

       
    }

}
