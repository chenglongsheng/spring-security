package cn.cls.demo2.service;

import cn.cls.demo2.entity.User;
import cn.cls.demo2.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserService extends IService<User> {
    Result<Map<String, String>> login(User user);
}
