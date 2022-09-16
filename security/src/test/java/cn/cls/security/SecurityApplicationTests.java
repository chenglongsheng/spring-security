package cn.cls.security;

import cn.cls.security.entity.User;
import cn.cls.security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testMybatisPlus() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
