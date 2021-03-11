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
+ 제대로 적용이 안될때가 있다.

ref : https://velog.io/@minsangk/%EC%BB%A4%EC%84%9C-%EA%B8%B0%EB%B0%98-%ED%8E%98%EC%9D%B4%EC%A7%80%EB%84%A4%EC%9D%B4%EC%85%98-Cursor-based-Pagination-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0

ref: https://wonyong-jang.github.io/database/2020/09/06/DB-Pagination.html

## Paging
### **Offset Based Pagination**
+ Oracle : https://jeong-pro.tistory.com/88

+ DB의 offset 쿼리를 사용하여 '페이지' 단위로 구분하여 요청/응답하게 구현

```sql
SELECT * FROM BOARD ORDER BY ID DESC LIMIT 0, 10;
SELECT * FROM BOARD ORDER BY ID DESC LIMIT 10, 10;
SELECT * FROM BOARD ORDER BY ID DESC LIMIT 20, 10;
```

+ 문제1. 각각의 페이지를 요청하는 사이에 데이터의 변화가 있는 경우 중복 데이터 노출

+ 문제2. 대부분의 RDBMS 에서 OFFSET 쿼리의 퍼포먼스 이슈
> row 수가 아주 많은 경우 offset 값이 올라갈 수록 쿼리의 퍼포먼스는 이에 비례하여 떨어지게 되어 있습니다.

고려할 시점
1. 데이터의 변화가 거의 없다시피하여 중복 데이터가 노출될 염려가 없는 경우
2. 일반 유저에게 노출되는 리스트가 아니라 중복 데이터가 노출되어도 크게 문제 되지 않는 경우
3. 검색엔진이 인덱싱 할 이유도, 유저가 마지막 페이지를 갈 이유도, 오래 된 데이터의 링크가 공유 될 이유도 없는 경우
4. 애초에 row 수가 그렇게 많지 않아 특별히 퍼포먼스 걱정이 필요 없는 경우


## **Cursor Based Pagination**

+ 클라이언트가 가져간 마지막 row의 순서상 다음 row들을 n개 요청/응답하게 구현

```sql
SELECT * FROM BOARD ORDER BY ID DESC LIMIT 10;
SELECT * FROM BOARD WHERE ID < {이전에 조회한 마지막 id} ORDER BY ID DESC LIMIT 10;
```



+ ID가 순차적이지 않고 UUID와 같이 비순차적이면 위의 방법은 의미가 없어진다. 
그럴때는 생성일과 ID를 기준으로 가져오는 방식을 생각해볼 수 있다.

+ JPA - Cursor paging - ref : https://alwayspr.tistory.com/45

```sql
SELECT * FROM BOARD ORDER BY CREATE_AT DESC, ID DESC LIMIT 10;
SELECT * FROM BOARD WHERE (CREATE_AT = {CREATE_AT} && ID < {ID}) OR (CREATE_AT < {CREATE_AT}) ORDER BY CREATE_AT DESC, ID DESC LIMIT 10;
```


## JPA Entity 연관관계

> JPA를 이용한다면 일반적인 테이블간의 관계를 이용하는 것처럼, 엔티티들 사이의 관계를 통해 데이터를 관리할 수 있다. 하지만,JPA를 사용하여 연관관계를 맺기 위해서는 참조 변수를 이용하기떄문에 테이블의연관과 엔티티의연관이 정확하게 일치하지 않는다

+ 단반향 연관관계

+ 양방향 연관관계
