package com.tangyuan.photo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 相册
 * </p>
 *
 * @author tang
 * @since 2021-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 相册名称
     */
    @TableId(value = "name", type = IdType.INPUT)
    private String name;

    /**
     * 文件夹随机名称
     */
    @TableField("uuName")
    private String uuName;


}
