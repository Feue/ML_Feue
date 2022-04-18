package com.feue.ml.repository;

import com.feue.ml.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-17 14:16
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);

    User findByPhone(String phone);
}
