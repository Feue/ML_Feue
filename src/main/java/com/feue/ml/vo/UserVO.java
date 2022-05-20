package com.feue.ml.vo;

import com.feue.ml.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Feue
 * @create 2022-05-16 20:22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    private Long id;
    private String username;
    private Character type;
    private String name;
    private String clazz;
    private String phone;
    private String email;

    public UserVO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.type = user.getType();
        this.name = user.getName();
        this.clazz = user.getClazz();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }
}
