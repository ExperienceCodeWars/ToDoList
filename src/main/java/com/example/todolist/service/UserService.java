package com.example.todolist.service;

import com.example.todolist.persist.entity.User;
import com.example.todolist.persist.repo.UserRepository;
import com.example.todolist.repr.UserRepr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.example.todolist.security.Utils.getCurrentUser;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRepr userRepr) {
        User user = new User();
        user.setUsername(userRepr.getUserName());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        userRepository.save(user);
    }

    public Optional<Long> getCurrentUserId() {
//        Optional<String> currentUser = getCurrentUser();
//        return currentUser.flatMap(userName -> userRepository.getUserByUsername(userName).map(User::getId));
        return getCurrentUser()
                .flatMap(userRepository::getUserByUsername)
                .map(User::getId);
    }
}
