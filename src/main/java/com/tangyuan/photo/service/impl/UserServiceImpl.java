package com.tangyuan.photo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangyuan.photo.controller.UUIDUtils;
import com.tangyuan.photo.entity.User;
import com.tangyuan.photo.mapper.UserMapper;
import com.tangyuan.photo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
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

    @Override
    public String login(String phone) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);
        User entity = getOne(userQueryWrapper);
        if (Objects.isNull(entity)){
            entity = new User();
            entity.setId(UUIDUtils.getInstance().getUUID());
            entity.setPhone(phone);
        }
        entity.setPhone(phone);
        saveOrUpdate(entity);
        return phone;
    }
}
