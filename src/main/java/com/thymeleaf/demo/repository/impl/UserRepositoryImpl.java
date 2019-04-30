package com.thymeleaf.demo.repository.impl;

import com.thymeleaf.demo.entity.User;
import com.thymeleaf.demo.repository.IUserRespository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class UserRepositoryImpl implements IUserRespository {

    private static Map<Long, User> userMap = new ConcurrentHashMap<>();
    private static AtomicLong counter = new AtomicLong(1);

    @Override

    public User saveOrUpdateUser(User user) {
        if (user.getId() == null) {
            user.setId(counter.getAndIncrement());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        userMap.remove(id);
    }

    @Override
    public User findUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(userMap.values());
    }

}
