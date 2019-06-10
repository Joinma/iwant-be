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

DROP TABLE IF EXISTS `t_team`;
CREATE TABLE IF NOT EXISTS `t_team`(
  `id` VARCHAR(36) NOT NULL COMMENT '表主键',
  `create_time` BIGINT COMMENT '添加时间',
  `update_time` BIGINT COMMENT '更新时间',
  `enabled` INT(1) NOT NULL DEFAULT 1 COMMENT '是否可见，0为不可见，1为可见',
  `sequence` INT NOT NULL DEFAULT 99 COMMENT '排序',
  `name` VARCHAR(20) COMMENT '团队名称',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='团队表' ;

DROP TABLE IF EXISTS `t_team_user`;
CREATE TABLE IF NOT EXISTS `t_team_user`(
  `id` VARCHAR(36) NOT NULL COMMENT '表主键',
  `create_time` BIGINT COMMENT '添加时间',
  `update_time` BIGINT COMMENT '更新时间',
  `enabled` INT(1) NOT NULL DEFAULT 1 COMMENT '是否可见，0为不可见，1为可见',
  `sequence` INT NOT NULL DEFAULT 99 COMMENT '排序',
  `team_id` VARCHAR(36) NOT NULL COMMENT '团队表主键',
  `user_id` VARCHAR(36) NOT NULL COMMENT '用户表主键',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='团队成员表' ;

DROP TABLE IF EXISTS `t_plan`;
CREATE TABLE IF NOT EXISTS `t_plan`(
  `id` VARCHAR(36) NOT NULL COMMENT '表主键',
  `create_time` BIGINT COMMENT '添加时间',
  `update_time` BIGINT COMMENT '更新时间',
  `enabled` INT(1) NOT NULL DEFAULT 1 COMMENT '是否可见，0为不可见，1为可见',
  `sequence` INT NOT NULL DEFAULT 99 COMMENT '排序',
  `start_time` BIGINT NOT NULL COMMENT '计划开始时间',
  `team_user_id` VARCHAR(36) COMMENT '团队成员表主键',
  `content` TEXT NOT NULL COMMENT '计划内容',
  `title` VARCHAR(50) COMMENT '计划标题',
  `reward` VARCHAR(512) COMMENT '奖励',
  `punish` VARCHAR(512) COMMENT '惩罚',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='计划表' ;

DROP TABLE IF EXISTS `t_wish_list`;
CREATE TABLE IF NOT EXISTS `t_wish_list`(
  `id` VARCHAR(36) NOT NULL COMMENT '表主键',
  `create_time` BIGINT COMMENT '添加时间',
  `update_time` BIGINT COMMENT '更新时间',
  `enabled` INT(1) NOT NULL DEFAULT 1 COMMENT '是否可见，0为不可见，1为可见',
  `sequence` INT NOT NULL DEFAULT 99 COMMENT '排序',
  `content` VARCHAR(255) NOT NULL COMMENT '愿望内容',
  `type` INT(1) NOT NULL DEFAULT 0 COMMENT '0：仅自己可见 1：指定团队可见',
  `team_id` VARCHAR(36) COMMENT '团队表主键',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='愿望清单表' ;

