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


