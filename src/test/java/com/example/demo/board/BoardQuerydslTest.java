package com.example.demo.board;

import java.util.List;

import com.example.demo.web.entity.Board;
import com.example.demo.web.repository.BoardRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJpaTest
public class BoardQuerydslTest {
 
    @Autowired
    BoardRepository boardRepository;

    // @Autowired
    // private JPAQueryFactory jpaQueryFactory;
 
    // @Test
    // public List<Board> findByName(String name) {
    //     // return jpaQueryFactory.selectFrom(board).fetch();
    // }
    @Test
    public void test(){
     //  BooleanBuilder builder = new BooleanBuilder();

    // QBoard board = QBoard.board;
    
    }
}
