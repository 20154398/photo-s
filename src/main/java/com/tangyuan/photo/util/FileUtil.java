package com.tangyuan.photo.util;

import com.tangyuan.photo.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FileUtil {

    public String transformName(String name) {
        String[] fileSplit = name.split("\\.");
        return DateUtil.getInstance().getTime(new Date()) + "." + fileSplit[fileSplit.length - 1];
    }

    public String saveFile(MultipartFile file, String userId) {
        File dest = createDirectory(file.getOriginalFilename(),"file", userId).toFile();
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BusinessException("文件转换失败");
        }
        return dest.getPath();
    }

    public Path createDirectory(String fileName, String... path) {
        Path dir = Paths.get(System.getProperty("user.dir"), path);
        try {
            if (!Files.isDirectory(dir)) {
                Files.createDirectories(dir);
            }
        } catch (IOException e) {
            throw new BusinessException("创建文件夹失败");
        }
        return Paths.get(dir + File.separator + fileName);
    }

    private static class SingletonHolder {
        private static final FileUtil INSTANCE = new FileUtil();
    }

    public static FileUtil getInstance() {
        return FileUtil.SingletonHolder.INSTANCE;
    }
}
