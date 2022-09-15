package cn.cls.securitydemo.service.impl;

import cn.cls.securitydemo.entity.User;
import cn.cls.securitydemo.mapper.UserMapper;
import cn.cls.securitydemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
