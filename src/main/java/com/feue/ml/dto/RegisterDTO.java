package com.feue.ml.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Feue
 * @create 2022-04-17 15:14
 */
@Getter
@Setter
@ToString
public class RegisterDTO {
    private String phone;
    private String password;
}
