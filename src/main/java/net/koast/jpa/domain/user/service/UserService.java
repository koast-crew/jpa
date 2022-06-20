package net.koast.jpa.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.koast.jpa.domain.user.dto.UserInfoDto;
import net.koast.jpa.domain.user.entity.UserInfo;
import net.koast.jpa.domain.user.persistence.UserMapStructMapper;
import net.koast.jpa.domain.user.persistence.UserRepository;
import net.koast.jpa.domain.user.persistence.UserSQLMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserSQLMapper userSQLMapper;
    private final UserRepository userRepository;

    /**
     * 사용자 수
     * @param userInfo
     * @return
     */
    @Transactional(readOnly=true)
    public Long getUserTotalCount(UserInfoDto userInfo) {
        return userSQLMapper.getUserTotalCount(userInfo);
    }

    /**
     * 사용자 목록
     * @param userInfo
     * @return
     */
    @Transactional(readOnly=true)
    public List<UserInfoDto> getListUser(UserInfoDto userInfo) {
        return userSQLMapper.getListUser(userInfo);
    }

    /**
     * @param userId
     * @return 특정 사용자의 정보
     */
    @Transactional(readOnly = true)
    public UserInfoDto findById(String userId) {
        UserInfo userInfo = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return UserMapStructMapper.INSTANCE.toDto(userInfo);
    }

    /**
     * 모든 사용자 목록을 불러온다.
     *
     * @param pageable
     * @return 모든 사용자 목록
     */
    @Transactional(readOnly = true)
    public Page<UserInfoDto> findAll(Pageable pageable) {
        Page<UserInfo> userPage = userRepository.findAll(pageable);

        return userPage.map(userInfo -> UserMapStructMapper.INSTANCE.toDto(userInfo));
    }
}
