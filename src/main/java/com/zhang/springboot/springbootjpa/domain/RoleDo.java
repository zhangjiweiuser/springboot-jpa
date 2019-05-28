package com.zhang.springboot.springbootjpa.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auth_role")
public class RoleDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 64)
    private String note;
}
