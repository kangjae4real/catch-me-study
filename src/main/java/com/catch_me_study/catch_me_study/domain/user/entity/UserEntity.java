package com.catch_me_study.catch_me_study.domain.user.entity;

import com.catch_me_study.catch_me_study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(insertable = false, updatable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 80, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    public void delete() {
        this.isDeleted = true;
    }

    public void update(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
