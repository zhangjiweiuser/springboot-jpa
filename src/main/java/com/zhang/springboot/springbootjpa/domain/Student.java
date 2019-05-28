package com.zhang.springboot.springbootjpa.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Student {

    @NotBlank
    private String name;
    @NotNull
    private int age;

    @NotBlank
    @Pattern(regexp = "1[357]\\d{9}",message = "手机号格式不正确")
    private String phone;

    @Size(min = 2,max = 10,message = "the license '${validatedValue}' must be between {min} and {max} characters lon")
    private String license;
}
