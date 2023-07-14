package com.example.JavaBlog.blog.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public String register (@RequestParam String username, @RequestParam String password) {
        // 这里添加处理用户注册的代码
        return "User registered";
    }

    @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password) {
        // 这里添加处理用户登录的代码
        return "User logged in";
    }

    @PostMapping("/logout")
    public String logout () {
        // 这里添加处理用户注销的代码
        return "User logged out";
    }

    @PostMapping("/change-password")
    public String changePassword (@RequestParam String oldPassword, @RequestParam String newPassword) {
        // 这里添加处理用户修改密码的代码
        return "Password changed";
    }
}
