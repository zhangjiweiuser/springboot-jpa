package com.zhang.springboot.springbootjpa.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@IdClass(RoleUserId.class)
@Table(name = "auth_role_user")
public class RoleUserDo {
    @Id
    private Long roleId;
    @Id
    private Long userId;
}
