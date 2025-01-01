package com.nba.modules.users.service;

import com.nba.modules.users.entities.User;
import com.nba.modules.users.repositories.UserRepository;

public class UserDetailsService {
    private final UserRepository userRepository;
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadUserByUsername(String username) throws Exception {
        User user = userRepository.findByUserName(username);
        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
            throw new Exception("User not found");
        }
        return user;
    }
}
