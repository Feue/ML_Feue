drop table if exists user;
create table user (
    id int unsigned not null auto_increment,
    username varchar(50) not null default '',
    type char(1) not null default '0',
    name varchar(50) null default null,
    clazz varchar(50) null default null,
    phone varchar(50) not null,
    email varchar(50) null default null,
    password varchar(20) not null default '123456',
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
auto_increment = 1
default charset = utf8mb4
collate = utf8mb4_general_ci;

drop table if exists category;
create table category
(
    id          int unsigned not null auto_increment,
    name        varchar(50)  not null default '',
    about       varchar(255) null     default null,
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4
  collate = utf8mb4_general_ci;

drop table if exists course;
create table course
(
    id          int unsigned not null auto_increment,
    name        varchar(50)  not null default '',
    about       varchar(255) null     default null,
    user_id     int unsigned not null,
    start_time  datetime(3)  null     default null,
    end_time    datetime(3)  null     default null,
    category_id int unsigned not null,
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4
  collate = utf8mb4_general_ci;

drop table if exists chapter;
create table chapter
(
    id          int unsigned not null auto_increment,
    `order`     int unsigned not null default 0,
    name        varchar(50)  null     default null,
    about       varchar(255) null     default null,
    course_id   int unsigned not null,
    start_time  datetime(3)  null     default null,
    end_time    datetime(3)  null     default null,
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4
  collate = utf8mb4_general_ci;

drop table if exists video;
create table video
(
    id          int unsigned not null auto_increment,
    `order`     int unsigned not null default 0,
    name        varchar(50)  not null default '',
    about       varchar(255) null     default null,
    src         varchar(255) not null default '',
    duration    int          null     default null,
    chapter_id  int unsigned not null,
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4
  collate = utf8mb4_general_ci;

drop table if exists comment;
create table comment
(
    id          int unsigned not null auto_increment,
    user_id     int unsigned not null,
    content     varchar(255) not null default '',
    level       int unsigned not null default 0,
    time        datetime(3)  not null default current_timestamp(3),
    chapter_id  int unsigned not null,
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4
  collate = utf8mb4_general_ci;

drop table if exists notice;
create table notice
(
    id          int unsigned not null auto_increment,
    name        varchar(255) not null default '',
    content     varchar(255) not null default '',
    user_id     int unsigned not null,
    create_time datetime(3)  not null default current_timestamp(3),
    update_time datetime(3)  not null default current_timestamp(3) on update current_timestamp(3),
    delete_time datetime(3)  null     default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4
  collate = utf8mb4_general_ci;