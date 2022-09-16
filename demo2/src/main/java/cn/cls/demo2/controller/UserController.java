package cn.cls.demo2.controller;

import cn.cls.demo2.entity.User;
import cn.cls.demo2.service.UserService;
import cn.cls.demo2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public Result<Map<String, String>> login(@RequestBody User user) {
        return userService.login(user);
    }

}
