-- 批发价格组表
-- DROP TABLE IF EXISTS `ts_wholeprice_group`;
CREATE TABLE `ts_wholeprice_group` (
  `wpg_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '批发价格组ID',
  `wpg_name` varchar(20) NOT NULL COMMENT '批发价格组名称',
  PRIMARY KEY (`wpg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


select * from tc_menu_sub

insert into tc_menu_sub values(55,3,'批发价格组',1,'/erp/wholepricegroup/index.yy','',20.5,'1001',now());

insert into tc_menu_sub values(56,3,'零售价格组',1,'/erp/salepricegroup/index.yy','',20.5,'1001',now());


insert into tc_menu_sub values(57,3,'表结构信息',1,'/erp/tablestruct/index.yy','',20.7,'1001',now());

insert into tc_menu_sub values(58,3,'表结构字段',1,'/erp/tablestructfield/index.yy','',20.8,'1001',now());




-- 零售价格组表
-- DROP TABLE IF EXISTS `ts_saleprice_group`;
CREATE TABLE `ts_saleprice_group` (
  `spg_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '零售价格组ID',
  `spg_name` varchar(20) DEFAULT NULL COMMENT '零售价格组名称',
  PRIMARY KEY (`spg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 商品批发价格组表
-- DROP TABLE IF EXISTS `tb_wares_wholeprice_group`;
CREATE TABLE `tb_wares_wholeprice_group` (
  `wpg_id` int(4) NOT NULL COMMENT '批发价格组ID',
  `w_id` int(4) NOT NULL COMMENT '商品ID',
  `w_wholeprice` decimal(14,4) DEFAULT NULL COMMENT '批发价',
  `u_id` int(4) null comment '用户ID',
  intime datetime null default now() comment '创建时间',
  PRIMARY KEY (`wpg_id`,`w_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 商品零售价格组表
-- DROP TABLE IF EXISTS `tb_wares_saleprice_group`;
CREATE TABLE `tb_wares_saleprice_group` (
  `spg_id` int(4) NOT NULL COMMENT '零售价格组ID',
  `w_id` int(4) NOT NULL COMMENT '商品ID',
  `w_saleprice` decimal(14,4) DEFAULT NULL COMMENT '零售价',
  `w_vipprice` decimal(14,4) DEFAULT NULL COMMENT '会员价',
  `w_promoprice` decimal(14,4) DEFAULT NULL COMMENT '促销价',
  `w_vippromoprice` decimal(14,4) DEFAULT NULL COMMENT '会员促销价',
  `w_status` int(1) DEFAULT '0' COMMENT '状态',
  `w_begindate` datetime DEFAULT NULL COMMENT '开始日期',
  `w_enddate` datetime DEFAULT NULL COMMENT '结束日期',
   `u_id` int(4) null comment '用户ID',
  intime datetime null default now() comment '创建时间',
  PRIMARY KEY (`spg_id`,`w_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 表结构信息表
create table ts_table_struct(
	ts_id int(2) auto_increment PRIMARY key comment '自增ID',
	ts_name varchar(30) not null comment '表名',
	ts_nikename varchar(50) not null comment '表简称',
	ts_type tinyint(1) null comment '表类型',
	ts_mId int(2) null comment '主表ID',
	ts_remark varchar(100) null comment '备注',
	intime datetime null default CURRENT_TIMESTAMP comment '创建时间' 
)

-- 表结构字段信息表
create table ts_table_struct_field(
	tsf_id int(2) auto_increment PRIMARY key comment '自增ID',
	ts_id int(2) null comment '所属表ID',
	tsf_name varchar(30) not null comment '字段名',
	tsf_nikename varchar(50) not null comment '字段名描叙',
	tsf_type varchar(20) null comment '字段类型',
	tsf_len varchar(5) null comment '字段长度',
	tsf_formtype varchar(20) null comment '表单中控件类',
	tsf_defval varchar(20) null comment '默认值',
	tsf_remark varchar(100) null comment '备注',
	intime datetime null comment '创建时间' 
)




