# Spring JPA - BOARD

+ H2 DataBase
+ Spring Data JPA
+ Thymeleaf
+ Lombok
+ Swagger 2.9


### **JPA paging**

+ JPA Pageable 은 기본적으로 zero Index / 20 size paging 이다.
+ 기본값을 One Index방식 / 10 size paging 로 바꾸려면 다음과 같이 bean 등록을 해주면 된다.

```java
@Bean 
public PageableHandlerMethodArgumentResolverCustomizer customize() { 
    return p -> { 
        p.setOneIndexedParameters(true); 
        // 1부터 시작 
        p.setMaxPageSize(10); 
        // size=10 
    }; 
}
```

## JPA Entity 연관관계

> JPA를 이용한다면 일반적인 테이블간의 관계를 이용하는 것처럼, 엔티티들 사이의 관계를 통해 데이터를 관리할 수 있다. 하지만,JPA를 사용하여 연관관계를 맺기 위해서는 참조 변수를 이용하기떄문에 테이블의연관과 엔티티의연관이 정확하게 일치하지 않는다

+ 단반향 연관관계

+ 양방향 연관관계
