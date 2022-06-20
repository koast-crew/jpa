package net.koast.jpa.domain.user.dto;

import lombok.*;
import net.koast.jpa.common.Search;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@ToString(callSuper = true)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto extends Search implements Serializable {

    private static final long serialVersionUID = 8349597082356588759L;

    // 고유번호
    @NotBlank
    private String userId;
    // 사용자 그룹 고유번호
    private Integer userGroupNo;
    // 사용자 그룹명(화면용)
    private String userGroupName;
    // 이름
    private String userName;
    // 비밀번호
    @NotBlank
    private String password;
    // 비밀번호 확인
    private String passwordConfirm;
    // 전화번호1
    private String telephone1;
    // 전화번호2
    private String telephone2;
    // 전화번호3
    private String telephone3;
    // 전화번호
    private String telephone;
    // 핸드폰 번호1
    private String mobilePhone1;
    // 핸드폰 번호2
    private String mobilePhone2;
    // 핸드폰 번호3
    private String mobilePhone3;
    // 핸드폰 번호
    private String mobilePhone;
    // 이메일
    private String email;
    // 이메일1
    private String email1;
    // 이메일2
    private String email2;
    // 변경할 이메리
    private String newEmail;
    // 메신저 아이디
    private String messenger;
    // 우편번호
    private String postalCode;
    // 주소
    private String address;
    // 상세주소
    private String addressEtc;
    // 사인인 횟수
    private Long loginCount;
    // 사인인 실패 횟수
    private Integer failLoginCount;
    // 마지막 사인인 비밀번호 변경 날짜
    private String lastPasswordChangeDate;
    // 마지막 사인인 날짜
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginDate;
    // 사용자 상태. 0:사용중, 1:사용중지(관리자), 2:잠금(비밀번호 실패횟수 초과), 3:휴면(사인인 기간), 4:만료(사용기간 종료), 5:삭제(화면 비표시, policy.user_delete_method=0), 6:임시비밀번호, 7:승인대기
    private String status;
    // 로그인 타입. BASIC :일반(플랫폼), SOCIAL : 소셜 로그인(구글, 페이스북, 네이버, 카카오)
    private String loginType;
    // 패스워드 변경 주기
    private String passwordChangeTerm;
    // 패스워드 변경 주기 값
    private Boolean passwordChangeTermOver;
    // 일정 기간 동안 미 접속시 잠금 처리 결과 값
    private Boolean userLastLoginLockOver;

    // 개인정보 수정 날짜
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;
    // 등록일
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
}