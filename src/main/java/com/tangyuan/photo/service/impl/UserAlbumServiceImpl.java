package com.tangyuan.photo.service.impl;

import com.tangyuan.photo.entity.UserAlbum;
import com.tangyuan.photo.mapper.UserAlbumMapper;
import com.tangyuan.photo.service.UserAlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 有权限的相册 服务实现类
 * </p>
 *
 * @author tang
 * @since 2021-09-24
 */
@Service
public class UserAlbumServiceImpl extends ServiceImpl<UserAlbumMapper, UserAlbum> implements UserAlbumService {

}
