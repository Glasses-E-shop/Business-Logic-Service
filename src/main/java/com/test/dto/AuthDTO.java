package com.test.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthDTO {
    private String email;
    private String password;
}
