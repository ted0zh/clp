package com.learningPlatform.CLP.data.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String role;
    private String avatar;

}
