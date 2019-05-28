package com.zhang.springboot.springbootjpa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_USER")
@Data
public class UserDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String account;
    @Column(length = 64)
    private String pwd;
}
