package com.tangyuan.photo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 精修
 * </p>
 *
 * @author tang
 * @since 2021-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RefinementPhoto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片名称
     */
    @TableId(value = "name", type = IdType.INPUT)
    private String name;

    /**
     * 相册名称
     */
    private String albumName;


}
