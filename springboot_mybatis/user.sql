CREATE TABLE `user`
(
    `user_id`      int(20)  NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `nick_name`    varchar(30) NOT NULL COMMENT '用户昵称',
    `email`        varchar(50)          DEFAULT '' COMMENT '用户邮箱',
    `phone_number` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号码',
    `gender`       int(1)               DEFAULT '0' COMMENT '用户性别（1男 0女 2未知）',
    `password`     varchar(100)         DEFAULT '' COMMENT '密码',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 115
  DEFAULT CHARSET = utf8 COMMENT ='用户信息表';

begin ;
insert into user
values (10, '花重月数', '13588990096@163.com', '13588990096', 1, '123');
insert into user
values (11, '旧梦如风°', '13588997833@163.com', '13588997833', 2, '123');
insert into user
values (12, '蝶舞庄周', '13588999869@163.com', '13588999869', 0, '123');
insert into user
values (13, '绿逾初夏', '13588992347@163.com', '13588992347', 2, '123');
insert into user
values (14, '余笙南吟', '13588998563@163.com', '13588998563', 1, '123');
insert into user
values (15, '陈情匿旧酒', '13588994646@163.com', '13588994646', 2, '123');
insert into user
values (16, '白桃乌龙', '13588997720@163.com', '13588997720', 1, '123');
insert into user
values (17, '清浅ˋ旧时光', '13588993478@163.com', '13588993478', 1, '123');
insert into user
values (18, '荒碎梦残', '13588992168@163.com', '13588992168', 2, '123');
insert into user
values (19, '伊人在水一方', '13588991297@163.com', '13588991297', 1, '123');
insert into user
values (20, '无梦相赠', '13588996630@163.com', '13588996630', 2, '123');
insert into user
values (21, '离人泪', '13588993312@163.com', '13588993312', 0, '123');
insert into user
values (22, '与我共梦', '13588992245@163.com', '13588992245', 2, '123');
insert into user
values (23, '挽弦暮笙', '13588996655@163.com', '13588996655', 1, '123');
insert into user
values (24, '开始厌倦', '13588993287@163.com', '13588993287', 2, '123');
insert into user
values (25, '仙女收纳盒', '13588992345@163.com', '13588992345', 1, '123');
insert into user
values (26, '華燈初上', '13588996542@163.com', '13588996542', 2, '123');
insert into user
values (27, '袖手今生', '13588992487@163.com', '13588992487', 1, '123');
commit ;