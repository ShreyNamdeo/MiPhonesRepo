package com.miMobiles.go.miMobiles.services;

import com.miMobiles.go.miMobiles.models.User;
import com.miMobiles.go.miMobiles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by shrey on 4/9/2019.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByEmail(String email){
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
}
