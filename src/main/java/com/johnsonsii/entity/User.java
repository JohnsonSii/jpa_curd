package com.johnsonsii.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String phone;
    @Column(name = "create_time")
    private String createTime;

}
