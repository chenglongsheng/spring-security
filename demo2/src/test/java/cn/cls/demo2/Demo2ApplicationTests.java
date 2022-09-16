package cn.cls.demo2;

import cn.cls.demo2.entity.User;
import cn.cls.demo2.mapper.UserMapper;
import cn.cls.demo2.util.JwtUtil;
import cn.cls.demo2.util.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisCache redisCache;

    @Test
    void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void testJwt() {
        String jwt = JwtUtil.createJWT("1");
        System.out.println(jwt);
    }

    @Test
    void testRedis() {
        redisCache.setCacheObject("1", "1");
    }

}
