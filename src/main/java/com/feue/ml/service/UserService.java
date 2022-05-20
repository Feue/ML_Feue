package com.feue.ml.service;

import com.feue.ml.dto.RegisterDTO;
import com.feue.ml.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Feue
 * @create 2022-04-17 14:11
 */
public interface UserService {
    List<User> findByUsername(String username);

    User findByPhone(String phone);

    Optional<User> findById(Long uid);

    User register(RegisterDTO dto);

    void delete(Long id);
}
