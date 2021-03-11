package com.example.demo.common.configuration;

import java.sql.DatabaseMetaData;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.sql.DataSource;

import com.example.demo.web.service.BoardReplyService;
import com.example.demo.web.service.BoardService;
import com.example.demo.web.service.dto.BoardReplySaveRequestDto;
import com.example.demo.web.service.dto.BoardSaveRequestDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class InitRunner implements CommandLineRunner{

    @Autowired
    private DataSource ds;

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardReplyService boardReplyService;

    private final int dummyCount = 300;
    Logger logger = LoggerFactory.getLogger(InitRunner.class);


    @Override
    public void run(String... args) throws Exception {
        DatabaseMetaData md = ds.getConnection().getMetaData();
        logger.info("{}", md.getDriverName());
        logger.info("{}", md.getURL());
        logger.info("{}", md.getUserName());

        logger.info("insertBoardDummyData : {}", dummyCount);
        // insertBoardDummyData(dummyCount);
    }
    
    private void insertBoardDummyData(int count){

        LongStream.rangeClosed(1, count).forEach(i -> {
            boardService.insert(new BoardSaveRequestDto("제목입니다" + i, "내용입니다" + i));

            IntStream.rangeClosed(1, 3).forEach(n->{
                boardReplyService.save(new BoardReplySaveRequestDto(i,"답변" + n));
            });
        });
    }

}
