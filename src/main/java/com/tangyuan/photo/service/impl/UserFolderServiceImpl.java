package com.tangyuan.photo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangyuan.photo.entity.UserFolder;
import com.tangyuan.photo.mapper.UserFolderMapper;
import com.tangyuan.photo.service.UserFolderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangyuan.photo.vo.PhotoVo;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 组 服务实现类
 * </p>
 *
 * @author tang
 * @since 2021-09-21
 */
@Service
public class UserFolderServiceImpl extends ServiceImpl<UserFolderMapper, UserFolder> implements UserFolderService {

    @Override
    public List<PhotoVo> search(String phone) {
//        QueryWrapper<UserFolder> userFolderQueryWrapper = new QueryWrapper<>();
//        userFolderQueryWrapper.eq("phone", phone);
//        UserFolder entity = getOne(userFolderQueryWrapper);
//        List<Path> paths = JSONObject.parseArray(entity.getJson(), Path.class);
        if (!phone.equals("18002332181")){
            if (!phone.equals("13666132412")) return null;
        }
        Path path = Paths.get("E:\\摄影\\相片\\锦里夜景\\100CANON");
        File file = path.toFile();
        return Arrays.stream(file.listFiles())
                .filter(f -> !f.getName().contains("_"))
                .filter(f -> f.getName().endsWith(".jpg") || f.getName().endsWith(".png") || f.getName().endsWith(".PNG") || f.getName().endsWith(".JPG"))
                .map(this::getUrl)
                .collect(Collectors.toList());
    }

    private PhotoVo getUrl(File file) {
        PhotoVo vo = new PhotoVo();
        vo.setBigPhoto("http://127.0.0.1:9000/photo/file" + file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("相片") + 2).replaceAll("\\\\", "/"));
        vo.setSmallPhoto("http://127.0.0.1:9000/photo/file" + file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("相片") + 2).replaceAll("\\\\", "/"));
        return vo;
    }
}
