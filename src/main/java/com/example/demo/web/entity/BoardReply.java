package com.example.demo.web.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
	@Column(name = "reply_id")
	private Long id;

	// @ManyToOne
	// @JoinColumn(name = "board_id")
	@Column(name = "board_id")
	private Long board_id;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String reply;

	@Column(name = "timestamp", columnDefinition = "tiemstamp DEFAULT NOT NULL CURRENT_TIMESTAMP")
	// @ColumnDefault("'CURRENT_TIMESTAMP()'")
	private Timestamp Timestamp;

	@Builder
	public BoardReply(Long board_id, String reply){
		this.board_id = board_id;
		this.reply = reply;
	}

}
