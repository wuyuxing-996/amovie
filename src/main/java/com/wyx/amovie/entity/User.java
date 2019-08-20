package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String nickname;
    private String email;
    private String password;
    private String salt;
    private String phone;
    private Integer gender;
    private Integer role;
}
