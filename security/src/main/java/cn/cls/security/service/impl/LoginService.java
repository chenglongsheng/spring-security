package cn.cls.security.service.impl;

import cn.cls.security.entity.User;
import cn.cls.security.uitl.Result;

public interface LoginService {
    Result login(User user);

    Result logout();
}
