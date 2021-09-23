package com.tangyuan.photo.controller;


import com.tangyuan.photo.service.UserFolderService;
import com.tangyuan.photo.service.UserService;
import com.tangyuan.photo.vo.PhotoVo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 组 前端控制器
 * </p>
 *
 * @author tang
 * @since 2021-09-21
 */
@RestController
@RequestMapping("/user-folder")
public class UserFolderController {
    @Resource
    private UserFolderService userFolderService;

    @GetMapping("search")
    public List<PhotoVo> search(String phone) {
        return userFolderService.search(phone);
    }
}
