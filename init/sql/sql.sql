CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(20) NOT NULL COMMENT '名字',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `gender` smallint(1) DEFAULT '1' COMMENT '性别1男 0女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;