package com.example.demo.web.repository;

import java.util.List;

import com.example.demo.web.entity.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
    Long save(Long id);
	
    // findAll
	List<Board> findAll();
	
	List<Board> findAll(Sort sort);
	
	Page<Board> findAll(Pageable pageable);

	Page<Board> findByAuthor(Pageable pageable, String author);

	

	// List<Board> findByStatus(String status);
	
	// Page<Board> findByByStatus(boolean status, Pageable Pageable);
}
