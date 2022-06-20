package net.koast.jpa.domain.user.persistence;

import net.koast.jpa.domain.user.entity.UserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface UserRepository extends JpaRepository<UserInfo, String> {
}
