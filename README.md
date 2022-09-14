# 基本原理

## 加载过程

SpringSecurity本质是一个过滤器链（有很多的过滤器）

`DelegatingFilterProxy.java`中

`doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)`

`initDelegate(WebApplicationContext wac)`

`FilterChainProxy.java`加载所有的过滤器链



## 两个重要接口

### UserDetailsService接口

当什么也没有配置的时候，账号和密码是由Spring Security定义生成的。而在实际项目中账号和密码都是从数据库中查询出来的。所以我们要通过自定义逻辑控制认证逻辑。



### PasswordEncoder

数据加密接口，用于返回User对象里面密码加密



# web权限方案

1、设置登录的用户名和密码

第一种方式：通过配置文件

```properties
spring.security.user.name=cls
spring.security.user.password=root
```



第二种方式：通过配置类

第三种方式：自定义编写实现类



## 认证



## 授权
