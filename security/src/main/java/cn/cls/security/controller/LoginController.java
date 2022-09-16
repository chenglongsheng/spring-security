package cn.cls.security.controller;

import cn.cls.security.entity.User;
import cn.cls.security.service.impl.LoginService;
import cn.cls.security.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public Result login(@RequestBody User user) {
        return loginService.login(user);
    }

    @GetMapping("/user/logout")
    public Result logout() {
        return loginService.logout();
    }

}
