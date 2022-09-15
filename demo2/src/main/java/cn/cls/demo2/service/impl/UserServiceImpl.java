package cn.cls.demo2.service.impl;

import cn.cls.demo2.entity.User;
import cn.cls.demo2.mapper.UserMapper;
import cn.cls.demo2.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
