package com.example.demo.web.entity;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.Assert;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
// @EqualsAndHashCode(of = "id")
@Table(name = "ACCOUNT")
@NoArgsConstructor
// @AllArgsConstructor
@ToString
@DynamicInsert
@DynamicUpdate
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ACCOUNT_ID")
    private Long id;

    @Column(name ="EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name ="PASSWORD", length = 120, nullable = false)
    private String password;

    @ColumnDefault("'USER'")
    @Column(name ="ROLE", length = 15, nullable = false)
    private String authority;


    // @Column(name ="JOIN_DATE", columnDefinition = "varchar(45) DEFAULT CURRENT_DATE()", nullable = false)
    @Column(name ="JOIN_DATE")
    @CreationTimestamp
    private Date joinDate;

    @Builder
    public Account(String email, String password, String authority) {
        Assert.hasText(email,    "@@@@@@@ : email must not be empty");
        Assert.hasText(password, "@@@@@@@ : password must not be empty");
        Assert.hasText(authority, "@@@@@@@ : authority must not be empty");

        this.email = email;
        this.userName = "User" + UUID.randomUUID();
        this.password = password;
        this.authority = authority;
        // this.joinDate = LocalDate.now();
    }
}
