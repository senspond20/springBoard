package com.example.demo.web.repository;

import java.util.List;

import com.example.demo.web.entity.BoardReply;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>{
    // List<BoardReply> findByBoard_id(Long board_id);
}
