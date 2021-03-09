package com.example.demo.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="board_reply")
public class BoardReply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_id")
	private Long id;

	// @ManyToOne
	// @JoinColumn(name = "board_id")
	// private Board bid;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String reply;

	// @Builder
	// public BoardReply(Long bid, String reply){
	// 	this.bid = bid;
	// 	this.reply = reply;
	// }
}
