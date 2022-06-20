package net.koast.jpa.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.koast.jpa.common.ResultResponse;
import net.koast.jpa.domain.user.dto.UserInfoDto;
import net.koast.jpa.domain.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@RestController
public class UserController {

    private final UserService userService;

    /**
     * 모든 사용자 목록
     *
     * @param pageable
     * @return
     */
    @GetMapping("/all")
    public ResultResponse<List<UserInfoDto>> all(Pageable pageable) {
        log.info("------------ pageable = {}", pageable);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setOffset(1L);
        userInfoDto.setLimit(20L);
        long totalCount = userService.getUserTotalCount(userInfoDto);

        List<UserInfoDto> users = userService.getListUser(userInfoDto);

        log.info("------------ users = {}", users);

        return ResultResponse.<List<UserInfoDto>>builder()
                .status(HttpStatus.OK.value())
                .payload(users)
                .errorMessage(null)
                .build();
    }

    /**
     * 모든 사용자 목록
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResultResponse<Page<UserInfoDto>> findAll(Pageable pageable) {
        log.info("------------ pageable = {}", pageable);
        Page<UserInfoDto> userInfoResponses = userService.findAll(pageable);

        return ResultResponse.<Page<UserInfoDto>>builder()
                .status(HttpStatus.OK.value())
                .payload(userInfoResponses)
                .errorMessage(null)
                .build();
    }

    /**
     * 특정 사용자 정보
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResultResponse<UserInfoDto> findById(@PathVariable String userId) {
        UserInfoDto userInfoResponses = userService.findById(userId);
        return ResultResponse.<UserInfoDto>builder().status(HttpStatus.OK.value()).payload(userInfoResponses).build();
    }
}
