package com.tangyuan.photo.service;

import com.tangyuan.photo.entity.UserFolder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tangyuan.photo.vo.PhotoVo;

import java.util.List;

/**
 * <p>
 * 组 服务类
 * </p>
 *
 * @author tang
 * @since 2021-09-21
 */
public interface UserFolderService extends IService<UserFolder> {

    List<PhotoVo> search(String id);
}
