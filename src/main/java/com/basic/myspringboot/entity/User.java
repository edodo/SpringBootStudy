package com.basic.myspringboot.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue
    private Long id;
    @Column
    @NotBlank(message = "Name 은 필수 입력 항목 입니다")
    private String name;
    @Column(unique=true)
    @NotBlank(message = "Email 은 필수 입력 항목 입니다")
    private String email;
}