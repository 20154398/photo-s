package com.tangyuan.photo.controller;


import com.tangyuan.photo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author tang
 * @since 2021-09-21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(String phone, String password) {
        return userService.login(phone, password);
    }
}
