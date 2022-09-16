package cn.cls.demo2.service.impl;

import cn.cls.demo2.entity.LoginUser;
import cn.cls.demo2.entity.User;
import cn.cls.demo2.mapper.UserMapper;
import cn.cls.demo2.service.UserService;
import cn.cls.demo2.util.JwtUtil;
import cn.cls.demo2.util.RedisCache;
import cn.cls.demo2.util.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Result<Map<String, String>> login(User user) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        if (authenticate == null) {
            throw new RuntimeException("用户名或密码错误");
        }
//        //4自己生成jwt给前端
//        LoginUser loginUser = (LoginUser) (authenticate.getPrincipal());
//        String userId = loginUser.getUser().getId().toString();
//        String jwt = JwtUtil.createJWT(userId);
//        Map<String, String> map = new HashMap<>();
//        map.put("token", jwt);
//        //5系统用户相关所有信息放入redis
//        redisCache.setCacheObject("login:" + userId, loginUser);
//        return new Result<>(map, 200, "登录成功");
        return null;
    }
}
