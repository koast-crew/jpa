package net.koast.jpa.domain.user.entity;

import lombok.*;
import net.koast.jpa.common.entity.BaseTimeEntity;
import net.koast.jpa.domain.usergroup.entity.UserGroup;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "user_info")
@Entity
public class UserInfo extends BaseTimeEntity implements Persistable<String> {

    @Id
    @Column(nullable = false, length = 32)
    private String userId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_group_no")
    private UserGroup userGroup;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String telephone;

    private String mobilePhone;

    private String email;

    private String messenger;

    private String postalCode;

    private String address;

    private String addressEtc;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private Long loginCount;

    private Integer failLoginCount;

    private LocalDateTime lastLoginDate;

    private LocalDateTime lastPasswordChangeDate;

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public boolean isNew() {
        return getCreatedDate() == null;
    }

    public void changeGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
        userGroup.getUsers().add(this);
    }
}