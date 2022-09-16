package cn.cls.security.service.impl;

import cn.cls.security.entity.LoginUser;
import cn.cls.security.entity.User;
import cn.cls.security.uitl.JwtUtil;
import cn.cls.security.uitl.RedisCache;
import cn.cls.security.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Result login(User user) {
        // 使用AuthenticationManager authenticationManager验证用户名密码
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);

        // 认证不通过提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }

        // 认证成功使用user生成jwt存入redis
        LoginUser authenticatedUser = (LoginUser) authenticate.getPrincipal();
        User userUser = authenticatedUser.getUser();
        String userId = userUser.getId().toString();
        redisCache.setCacheObject("login:" + userId, userUser);
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 返回jwt给前端
        return new Result(map, 200, "登录成功");
    }
}
