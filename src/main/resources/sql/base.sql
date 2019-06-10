DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user`(
  `id` VARCHAR(36) NOT NULL COMMENT '表主键',
  `create_time` BIGINT COMMENT '添加时间',
  `update_time` BIGINT COMMENT '更新时间',
  `enabled` INT(1) NOT NULL DEFAULT 1 COMMENT '是否可见，0为不可见，1为可见',
  `sequence` INT NOT NULL DEFAULT 99 COMMENT '排序',
  `nick_name` VARCHAR(20) COMMENT '用户昵称',
  `open_id` VARCHAR(255) UNICODE NOT NULL COMMENT '微信open_id',
  `avatar_url` TEXT COMMENT '微信头像url',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表' ;