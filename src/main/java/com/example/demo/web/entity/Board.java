package com.example.demo.web.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

// import org.hibernate.annotations.ColumnDefault;
// import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//일반 자바빈 규약대로 @Getter/@Setter를 만들기 쉽지만
//@Entity 가 붙으면 @Setter를 만들어서는 안된다.
//-> 해당 인스턴스의 값들이 언제 변경되는지 구분하기가 어려워서 향후 굉장히 복잡해진다.
//대신 필드를 변경하고자 한다면 목적과 이유가 명확해야 한다.-> update 제공

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate 
@Table(name ="board")
@ToString
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;
	
	@Column(length = 155, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column(name = "AUTHOR")
	// @ManyToOne
	// @JoinColumn(name ="ACCOUNT_ID")
	private String author;

	// @OneToMany
	// @JoinTable(name = "board_reply")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "board_id")  // <-- 여기!!
	private List<BoardReply> reply = new ArrayList<>();
	

	// @Column(name = "status", length = 1)
	// @ColumnDefault("'Y'") 
	// private char status
	// ==> "\u0000", 로 들어간다

	// 1 True : 공개 , 0 False : 비공개
	// @Column(name ="status", columnDefinition = "CHAR(1) NOT NULL DEFAULT 'Y'")
	@Column(name ="status", columnDefinition = "TINYINT(1) NOT NULL DEFAULT 1")
	// @ColumnDefault("'True'")
	// @Convert(converter = BooleanToYNConverter.class)
	private boolean isShow;

	@CreationTimestamp
	private Date createTime;

	// @Column(name ="tiemstamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")

	// @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@UpdateTimestamp
	private Timestamp updateTime;
	

	@Builder // 빌더패턴 적용
	public Board(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.isShow = true;
		this.author = author;
		// this.createTime = LocalDateTime.now();
		// this.status = "Y";
	}

	// update 수정 setter대신
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}

