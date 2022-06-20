package net.koast.jpa.domain.user.persistence;

import net.koast.jpa.domain.user.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 사용자
 * @author jeongdae
 *
 */
@Mapper
@Repository
public interface UserSQLMapper {

    /**
     * 사용자 수
     * @param userInfo
     * @return
     */
    Long getUserTotalCount(UserInfoDto userInfo);

    /**
     * 사용자 목록
     * @param userInfo
     * @return
     */
    List<UserInfoDto> getListUser(UserInfoDto userInfo);
}