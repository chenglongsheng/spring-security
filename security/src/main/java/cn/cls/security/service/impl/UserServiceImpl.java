package cn.cls.security.service.impl;

import cn.cls.security.entity.User;
import cn.cls.security.mapper.UserMapper;
import cn.cls.security.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
