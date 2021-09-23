package com.tangyuan.photo.service;

import com.tangyuan.photo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author tang
 * @since 2021-09-21
 */
public interface UserService extends IService<User> {

    String login(String phone);
}
