package com.example.demo.web.service.dto;

import com.example.demo.common.dto.ResponseData;
import com.example.demo.web.entity.Board;

import lombok.Getter;

/**
 * @author        gun
 */
@Getter
public class BoardResponseDto implements ResponseData{
	
	private Long id;
	private String title;
	private String author;
	
	public BoardResponseDto(Board Entity) {
		super();
		this.id = Entity.getId();
		this.title = Entity.getTitle();
		this.author = Entity.getAuthor();
	}
	
}
