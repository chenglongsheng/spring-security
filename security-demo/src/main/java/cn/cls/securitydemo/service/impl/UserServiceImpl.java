package cn.cls.securitydemo.service.impl;

import cn.cls.securitydemo.common.R;
import cn.cls.securitydemo.entity.LoginUser;
import cn.cls.securitydemo.entity.User;
import cn.cls.securitydemo.mapper.UserMapper;
import cn.cls.securitydemo.service.UserService;
import cn.cls.securitydemo.util.JwtUtil;
import cn.cls.securitydemo.util.RedisCache;
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
    public R<Map<String, String>> login(User user) {
        //验证用户名和密码
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        // 验证失败
        if (!authenticate.isAuthenticated()) {
            throw new RuntimeException("用户名或密码错误！");
        }
        //成功
        //生成jwt返回给前端
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token" , jwt);
        // 把用户信息存入缓存
        redisCache.setCacheObject("login:" + userId, loginUser);
        return R.ok(map);
    }
}
