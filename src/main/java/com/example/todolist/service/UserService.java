package com.example.todolist.service;

import com.example.todolist.persist.entity.User;
import com.example.todolist.persist.repo.UserRepository;
import com.example.todolist.repr.UserRepr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(UserRepr userRepr){
        User user = new User();
        user.setUsername(userRepr.getUserName());
        user.setPassword(userRepr.getPassword());
        userRepository.save(user);
    }
}
