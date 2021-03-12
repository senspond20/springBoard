package com.example.demo.web.service.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.common.model.ResponseData;
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
	private String date;
	private String url;
	
	public BoardResponseDto(Board Entity) {
		super();
		
		this.id = Entity.getId();
		this.title = Entity.getTitle();
		this.author = Entity.getAuthor();

		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		this.date =  format.format(Entity.getUpdateTime());
		this.url = "/api/board/" + id;
	}

}
