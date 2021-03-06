-- FK, Index 는 별도 파일로 분리. 맨 마지막에 작업 예정
drop table if exists user_group cascade;
drop table if exists user_info cascade;


-- 사용자 그룹
create table user_group(
    user_group_no				integer,
    user_group_key				varchar(60)							not null ,
    user_group_name				varchar(100)						not null,
    ancestor					integer								default 0,
    parent						integer								default 1,
    depth						integer								default 1,
    view_order					integer								default 1,
    children					integer								default 0,
    basic						boolean								default false,
    available					boolean								default true,
    description					varchar(256),
    modified_date					timestamp with time zone,
    created_date					timestamp with time zone			default now(),
    constraint user_group_pk 	primary key (user_group_no)
);

comment on table user_group is '사용자 그룹';
comment on column user_group.user_group_no is '고유번호';
comment on column user_group.user_group_key is '링크 활용 등을 위한 확장 컬럼';
comment on column user_group.user_group_name is '그룹명';
comment on column user_group.ancestor is '조상 고유번호';
comment on column user_group.parent is '부모 고유번호';
comment on column user_group.depth is '깊이';
comment on column user_group.view_order is '나열 순서';
comment on column user_group.children is '자식 존재 개수';
comment on column user_group.basic is '삭제 불가, true : 기본, false : 선택';
comment on column user_group.available is '사용유무, true : 사용, false : 사용안함';
comment on column user_group.description is '설명';
comment on column user_group.modified_date is '수정일';
comment on column user_group.created_date is '등록일';


-- 사용자 기본정보
create table user_info(
    user_id						varchar(32),
    user_group_no				integer								not null,
    user_name					varchar(64)							not null,
    password					varchar(512)						not null,
    telephone					varchar(256),
    mobile_phone				varchar(256),
    email						varchar(256),
    messenger					varchar(100),
    postal_code					varchar(6),
    address						varchar(256),
    address_etc					varchar(1000),
    status                      varchar(32)                         default 'USE',
    login_type					varchar(20)							default 'BASIC',
    user_role_check_yn			char(1)								default 'Y',
    login_count				    bigint								default 0,
    fail_login_count			integer								default 0,
    last_login_date			    timestamp with time zone,
    last_password_change_date	timestamp with time zone			default now(),
    modified_date					timestamp with time zone,
    created_date					timestamp with time zone			default now(),
    constraint user_info_pk primary key(user_id)
);

comment on table user_info is '사용자 기본정보';
comment on column user_info.user_id is '고유번호';
comment on column user_info.user_group_no is '사용자 그룹 고유번호';
comment on column user_info.user_name is '이름';
comment on column user_info.password is '비밀번호';
comment on column user_info.telephone is '전화번호';
comment on column user_info.mobile_phone is '핸드폰 번호';
comment on column user_info.email is '이메일';
comment on column user_info.messenger is '메신저 아이디';
comment on column user_info.postal_code is '우편번호';
comment on column user_info.address is '주소';
comment on column user_info.address_etc is '상세주소';
comment on column user_info.user_role_check_yn is '최초 사인인시 사용자 Role 권한 체크 패스 기능. 기본값 Y : 체크';
comment on column user_info.status is '사용자 상태. USE:사용중, FORBID:사용중지(관리자), FAIL_LOGIN_COUNT_OVER:잠금(비밀번호 실패횟수 초과), SLEEP:휴면(사인인 기간), TERM_END:만료(사용기간 종료), LOGICAL_DELETE:삭제(화면 비표시, policy.user_delete_type=0), TEMP_PASSWORD:임시비밀번호, APPROVAL_WAIT:승인대기';
comment on column user_info.login_type is '로그인 유형. 1:일반(플랫폼), 2:소셜 로그인(구글, 페이스북, 네이버, 카카오)';
comment on column user_info.login_count is '사인인 횟수';
comment on column user_info.fail_login_count is '사인인 실패 횟수';
comment on column user_info.last_login_date is '마지막 사인인 날짜';
comment on column user_info.last_password_change_date is '마지막 사인인 비밀번호 변경 날짜';
comment on column user_info.modified_date is '개인정보 수정 날짜';
comment on column user_info.created_date is '등록일';


