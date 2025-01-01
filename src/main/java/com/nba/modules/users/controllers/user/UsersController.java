package com.nba.modules.users.controllers.user;

import com.nba.modules.users.entities.User;
import com.nba.modules.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestBody AddUserRequest request) throws Exception {
        try {
            System.out.println("\u001B[32m" + request.getFirstName() + "\u001B[0m");
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setUserName(request.getUserName());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            System.out.println("\u001B[31m" + user.getId() + "\u001B[0m");
            userRepository.save(user);
            return "Success";
        } catch (Exception e) {
            throw new Exception("Adding user went wrong");
        }
    }

    @GetMapping("/list")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userRepository.findUserById(id);
    }
}

