package cn.cls.securitydemo.controller;

import cn.cls.securitydemo.common.R;
import cn.cls.securitydemo.entity.User;
import cn.cls.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<Map<String, String>> login(@RequestBody User user) {
        return userService.login(user);
    }

}
