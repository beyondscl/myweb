package com.bird.domain;


import lombok.Data;

/**
 * author: 牛虻.
 * time:2017/11/19 0019
 * email:pettygadfly@gmail.com
 * doc:
 */
@Data
public class User {
    private String id;
    private String name;
    private String password;
    private int age;
}