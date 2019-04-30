package com.thymeleaf.demo.repository;

import com.thymeleaf.demo.entity.User;

import java.util.List;

public interface IUserRespository {
    User saveOrUpdateUser(User user);

    void deleteUserById(Long id);

    User findUserById(Long id);

    List<User> listUsers();
}
