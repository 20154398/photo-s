SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`    varchar(32) not null COMMENT 'ID',
    `phone` varchar(32) not null COMMENT '手机号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='用户';

DROP TABLE IF EXISTS `user_folder`;
CREATE TABLE `user_folder`
(
    `id`    varchar(32) not null COMMENT 'ID',
    `phone` varchar(32) DEFAULT null COMMENT '名称',
    `json`  text        DEFAULT null COMMENT '文件夹',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='组';


SET FOREIGN_KEY_CHECKS = 1;