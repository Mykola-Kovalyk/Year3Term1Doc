package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends CSVRepository<User> {

    public UserRepository() {
        super("users");
    }
    
    @Override
    public User newResource() {
        return new User();
    }
}
