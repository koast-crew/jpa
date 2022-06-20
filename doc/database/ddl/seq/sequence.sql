
drop sequence if exists user_group_seq;

create sequence user_group_seq increment 1 minvalue 1 maxvalue 999999999999 start 100 cache 1;
