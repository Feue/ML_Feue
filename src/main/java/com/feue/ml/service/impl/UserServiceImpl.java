package com.feue.ml.service.impl;

import com.feue.ml.dto.RegisterDTO;
import com.feue.ml.entity.User;
import com.feue.ml.repository.UserRepository;
import com.feue.ml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2022-04-17 14:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public Optional<User> findById(Long uid) {
        return userRepository.findById(uid);
    }

    @Override
    public List<String> findAllTeacherNameByIds(List<Long> ids) {
        List<User> userList = new ArrayList<>();
        for (Long id : ids) {
            userList.add(userRepository.getById(id));
        }
        return userList.stream().map(User::getName).collect(Collectors.toList());
    }

    @Override
    public User register(RegisterDTO dto) {
        User user = User.builder()
                .phone(dto.getPhone())
                .password(dto.getPassword())
                .build();
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        Date now = new Date();
        userRepository.deleteById(id, now);
    }
}
