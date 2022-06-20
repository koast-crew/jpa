package net.koast.jpa.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PasswordTest {

    @Test
    @DisplayName("로그인 비밀번호 암호화")
    public void encrypt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = "test";
        log.info("password = {}", password);
        String encodePassword = bCryptPasswordEncoder.encode(password);
        log.info("encodePassword = {}", encodePassword);
    }
}