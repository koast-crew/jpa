package net.koast.jpa.domain.user.entity;

public enum UserStatus {
    // 사용중
    USE,
    // 사용자 상태가 중지(관리자)
    FORBID,
    // 사용자 상태가 잠금(비밀번호 실패횟수 초과)
    FAIL_LOGIN_COUNT_OVER,
    // 사용자 상태가 휴면(로그인 기간)
    SLEEP,
    // 사용자 상태가 만료(사용기간 종료)
    TERM_END,
    // 사용자 상태가 삭제(화면 비표시)
    LOGICAL_DELETE,
    // 사용자 상태가 임시 비밀번호(비밀번호 찾기, 관리자 설정에 의한 임시 비밀번호 발급 시)
    TEMP_PASSWORD,
    // 승인대기
    APPROVAL_WAIT
}