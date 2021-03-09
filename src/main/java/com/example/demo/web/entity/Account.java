// package com.example.demo.web.entity;
// import java.time.LocalDate;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import org.hibernate.annotations.ColumnDefault;
// import org.hibernate.annotations.DynamicInsert;
// import org.springframework.util.Assert;

// import lombok.Builder;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.ToString;

// @Getter
// @EqualsAndHashCode(of = "id")
// @Table(name = "ACCOUNT")
// @NoArgsConstructor
// @ToString
// @Entity
// @DynamicInsert
// public class Account {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name ="ID")
//     private Long id;

//     @Column(name ="EMAIL", unique = true, nullable = false)
//     private String email;

//     @Column(name ="PASSWORD", length = 120, nullable = false)
//     private String password;

//     @ColumnDefault("'USER'")
//     @Column(name ="ROLE", length = 15, nullable = false)
//     private String authority;

//     @Column(name ="JOIN_DATE", columnDefinition = "varchar(45) DEFAULT CURRENT_DATE()", nullable = false)
//     private LocalDate  joinDate = LocalDate.now();

//     @Builder
//     public Account(String email, String password, String authority) {
//         Assert.hasText(email,    "@@@@@@@ : email must not be empty");
//         Assert.hasText(password, "@@@@@@@ : password must not be empty");
//         Assert.hasText(authority, "@@@@@@@ : authority must not be empty");

//         this.email = email;
//         this.password = password;
//         this.authority = authority;
//         this.joinDate = LocalDate.now();
//     }
// }
