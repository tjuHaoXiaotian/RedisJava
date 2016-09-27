
create table user (
  id int not null auto_increment PRIMARY KEY comment 'id',
  username VARCHAR(54) not null COMMENT '用户名',
  password CHAR(32) not null COMMENT 'md5 后的密码',
  salt CHAR(32) NOT NULL COMMENT 'md5 盐'
)engine = innodb default charset = utf8 AUTO_INCREMENT = 1;

insert into user(username,password,salt)
values ('root','root','root');