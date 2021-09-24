package com.tangyuan.photo.controller;


import com.tangyuan.photo.service.UserAlbumService;
import com.tangyuan.photo.service.UserFolderService;
import com.tangyuan.photo.vo.PhotoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 有权限的相册 前端控制器
 * </p>
 *
 * @author tang
 * @since 2021-09-24
 */
@RestController
@RequestMapping("/user-album")
public class UserAlbumController {

}
