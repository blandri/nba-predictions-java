package com.nba.modules.users.repositories;

import com.nba.modules.users.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String name);
    User findUserById(Integer id);
}


