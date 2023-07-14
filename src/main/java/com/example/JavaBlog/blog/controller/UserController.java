package com.example.JavaBlog.blog.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    // 一个简单的用户数据库
    private Map<String, String> users = new HashMap<>();

    @PostMapping("/register")
    public String register (@RequestParam String username, @RequestParam String password) {
        if (users.containsKey(username)) {
            return "Username already exists";
        }
        users.put(username, password);
        return "User registered";
    }

    @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password) {
        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return "User logged in";
        } else {
            return "Wrong username or password";
        }
    }

    @PostMapping("/logout")
    public String logout () {
        // 无状态的 REST API，无法真正地注销用户
        return "User logged out";
    }

    @PostMapping("/change-password")
    public String changePassword (@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) {
        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(oldPassword)) {
            users.put(username, newPassword);
            return "Password changed";
        } else {
            return "Wrong username or password";
        }
    }
}
