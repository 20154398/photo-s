package com.tangyuan.photo.util;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanCopier {

    public static <T, S> List<T> copyList(List<S> source, Class<T> targetClz){
        return copyList(source, targetClz, true);
    }

    public static <T, S> List<T> copyList(List<S> source, Class<T> targetClz, boolean ignoreNull){
        int len = source.size();
        List<T> res = Lists.newArrayListWithCapacity(len);
        source.forEach(s -> res.add(copy(s,targetClz,ignoreNull)));
        return res;
    }

    public static <T> T copy(Object source, Class<T> targetClz){
        return copy(source, targetClz, true);
    }

    @SneakyThrows
    public static <T> T copy(Object source, Class<T> targetClz, boolean ignoreNull){
        T target = targetClz.newInstance();
        if (ignoreNull){
            BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        }else {
            BeanUtils.copyProperties(source, target);
        }
        return target;
    }

    private static String[] getNullPropertyNames(Object source) throws IllegalAccessException {
        Field[] fields = source.getClass().getDeclaredFields();
        List<String> ignoreCopyProperties = new ArrayList<>();
        for (int i = fields.length - 1; i >= 0; i--) {
            Field field = fields[i];
            //打开私有访问
            boolean canAccess = field.isAccessible();
            if (!canAccess) {
                field.setAccessible(true);
            }
            Object fieldValue = field.get(source);
            if (fieldValue == null) {
                ignoreCopyProperties.add(field.getName());
            }
            field.setAccessible(canAccess);
        }
        return ignoreCopyProperties.toArray(new String[0]);
    }
}
