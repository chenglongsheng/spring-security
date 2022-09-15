package cn.cls.securitydemo;

import cn.cls.securitydemo.entity.User;
import cn.cls.securitydemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Test
    void contextLoads() {

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("test")
                .setSubject("testJwt")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "clswudi");
        String jwt = jwtBuilder.compact();
        System.out.println(jwt);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelect() {
        List<User> users = userMapper.selectList(Wrappers.emptyWrapper());
        System.out.println(users);
    }

}
