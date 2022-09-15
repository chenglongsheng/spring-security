package cn.cls.securitydemo.service;

import cn.cls.securitydemo.common.R;
import cn.cls.securitydemo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserService extends IService<User> {
    R<Map<String, String>> login(User user);
}
