package cn.cls.securitydemo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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

}
