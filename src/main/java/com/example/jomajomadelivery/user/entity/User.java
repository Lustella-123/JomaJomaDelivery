package com.example.jomajomadelivery.user.entity;

import com.example.jomajomadelivery.common.BaseEntity;
import com.example.jomajomadelivery.user.dto.request.SignUpUserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String nickName;

    private String phoneNumber;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Address> addresses = new ArrayList<>(); Todo: Address 클래스 연결 필요

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    public static User createUser(SignUpUserDto dto) {
        return User.builder()
                .email(dto.email())
                .password(dto.password())
                .name(dto.name())
                .role(dto.role())
                .nickName(dto.nickname())
                .phoneNumber(dto.phoneNumber())
                .isDeleted(false)
                .build();
    }
}
