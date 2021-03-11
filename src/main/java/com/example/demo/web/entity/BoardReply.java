package com.example.demo.web.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate 
@Table(name ="board_reply")
public class BoardReply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_id", columnDefinition = "INT(11)")
	private Long no;

	// @ManyToOne
	// @JoinColumn(name = "board_id")
	@Column(name = "board_id")
	private Long board_id;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String reply;

	// @Column(name ="tiemstamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Timestamp Timestamp;

	@Builder
	public BoardReply(Long board_id, String reply){
		this.board_id = board_id;
		this.reply = reply;
	}

}
