SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `phone`    varchar(32) not null COMMENT '手机号',
    `password` varchar(32) not null COMMENT '密码',
    PRIMARY KEY (`phone`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='用户';

DROP TABLE IF EXISTS `user_album`;
CREATE TABLE `user_album`
(
    `id`         varchar(32) not null COMMENT 'ID',
    `phone`      varchar(32) not null COMMENT '名称',
    `album_name` varchar(32) not null COMMENT '相册名称',
    PRIMARY KEY (`id`) USING BTREE,
    index (`phone`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='有权限的相册';

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`
(
    `name`   varchar(32) not null COMMENT '相册名称',
    `uuName` varchar(32) not null COMMENT '文件夹随机名称',
    PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='相册';


DROP TABLE IF EXISTS `original_photo`;
CREATE TABLE `original_photo`
(
    `name`       varchar(32) not null COMMENT '图片名称',
    `album_name` varchar(32) not null COMMENT '相册名称',
    `uuName`     varchar(32) not null COMMENT '文件夹随机名称',
    PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='原图';

DROP TABLE IF EXISTS `refinement_photo`;
CREATE TABLE `refinement_photo`
(
    `name`       varchar(32) not null COMMENT '图片名称',
    `album_name` varchar(32) not null COMMENT '相册名称',
    PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='精修';


SET FOREIGN_KEY_CHECKS = 1;