package net.koast.jpa.domain.usergroup.entity;

import lombok.*;
import net.koast.jpa.common.entity.BaseTimeEntity;
import net.koast.jpa.domain.user.entity.UserInfo;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@ToString(exclude = "users")
@Builder
@Getter
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "user_group_seq_generator", sequenceName = "user_group_seq", allocationSize = 1)
@Entity
public class UserGroup extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "user_group_seq_generator")
    @Column(name = "user_group_no")
    private Integer userGroupNo;

    @Builder.Default
    @OneToMany(mappedBy = "userGroup")
    private List<UserInfo> users = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String userGroupName;

    private Integer ancestor;

    private Integer parent;

    private Integer depth;

    private Integer viewOrder;

    private Integer children;

    private Boolean basic;

    private Boolean available;

    private String description;

    public void join(UserInfo userInfo) {
        users.add(userInfo);
    }
}