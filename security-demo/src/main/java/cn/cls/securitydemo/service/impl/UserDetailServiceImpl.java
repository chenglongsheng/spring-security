package cn.cls.securitydemo.service.impl;

import cn.cls.securitydemo.entity.LoginUser;
import cn.cls.securitydemo.entity.User;
import cn.cls.securitydemo.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    /***
     * 给系统加载用户名自动校验
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getUserName, username));
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名错误！");
        }
        return new LoginUser(user);
    }
}
