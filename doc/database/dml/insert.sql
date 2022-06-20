insert into user_group(	user_group_no, user_group_key, user_group_name, ancestor, parent, depth, view_order, basic, available, description)
values
    (1, 'SUPER_ADMIN', '슈퍼 관리자', 1, 0, 1, 1, 'Y', 'Y', '기본값'),
    (2, 'USER', '사용자', 1, 0, 1, 2, 'Y', 'Y', '기본값');

-- 슈퍼 관리자 등록
insert into user_info(
    user_id, user_group_no, user_name, password, last_login_date)
values
    ('admin', 1, '슈퍼관리자', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test1', 2, '테스트1', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test2', 2, '테스트2', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test3', 2, '테스트3', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test4', 2, '테스트4', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test5', 2, '테스트5', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test6', 2, '테스트6', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test7', 2, '테스트7', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test8', 2, '테스트8', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test9', 2, '테스트9', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test10', 2, '테스트10', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test11', 2, '테스트11', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test12', 2, '테스트12', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test13', 2, '테스트13', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test14', 2, '테스트14', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test15', 2, '테스트15', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test16', 2, '테스트16', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test17', 2, '테스트17', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test18', 2, '테스트18', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test19', 2, '테스트19', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test20', 2, '테스트20', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test21', 2, '테스트21', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test22', 2, '테스트22', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test23', 2, '테스트23', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now()),
    ('test24', 2, '테스트24', '$2a$10$4MLyHDGhNXjW1w3pl3WH4udhlJlUWQQMBMaJXdk8lr.GwNexkfo2W', now());