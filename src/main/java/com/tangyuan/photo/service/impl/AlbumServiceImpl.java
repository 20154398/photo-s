package com.tangyuan.photo.service.impl;

import com.tangyuan.photo.entity.Album;
import com.tangyuan.photo.mapper.AlbumMapper;
import com.tangyuan.photo.service.AlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相册 服务实现类
 * </p>
 *
 * @author tang
 * @since 2021-09-24
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {

}
