package cn.cls.demo2;

import cn.cls.demo2.entity.User;
import cn.cls.demo2.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
