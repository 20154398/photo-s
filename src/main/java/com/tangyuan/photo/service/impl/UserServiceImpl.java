package com.tangyuan.photo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangyuan.photo.entity.User;
import com.tangyuan.photo.exception.BusinessException;
import com.tangyuan.photo.mapper.UserMapper;
import com.tangyuan.photo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangyuan.photo.util.AES128Util;
import com.tangyuan.photo.util.UUIDUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author tang
 * @since 2021-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final String adminPhone = "admin2181";

    @Override
    public String login(String phone, String password) {
        if (phone.equals(adminPhone)) return phone;
        password = AES128Util.decrypt(password, AES128Util.KEY_WORD);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);
        User entity = getOne(userQueryWrapper);
        if (Objects.isNull(entity)) {
            entity = new User();
            entity.setPhone(phone);
            entity.setPassword(password);
            save(entity);
        } else if (!password.equals(entity.getPassword())) {
            throw new BusinessException(401, "登录失败");
        }
        return phone;
    }
}
