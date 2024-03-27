package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.User;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
