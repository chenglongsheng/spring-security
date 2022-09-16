package cn.cls.security;

import cn.cls.security.entity.User;
import cn.cls.security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testBCryptPasswordEncoder() {
        String encode = passwordEncoder.encode("123");
        String encode2 = passwordEncoder.encode("123");
        System.out.println(encode);
        System.out.println(encode2);
    }

    @Test
    void testMybatisPlus() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
