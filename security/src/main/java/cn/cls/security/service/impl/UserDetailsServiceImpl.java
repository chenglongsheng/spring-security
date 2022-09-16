package cn.cls.security.service.impl;

import cn.cls.security.entity.LoginUser;
import cn.cls.security.entity.User;
import cn.cls.security.mapper.MenuMapper;
import cn.cls.security.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, username));

        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }

        List<String> permission = menuMapper.selectPermsByUserId(user.getId());

        return new LoginUser(user, permission);
    }
}
