package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.User;
import com.lpnu.iot.cornerstoneondemand.structure.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

    @PostMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String phone, @RequestParam String email) throws Exception {
        if(name == null || phone == null || email == null)
            throw new Exception("Invalid user data");

        User user = new User(name, phone, email);
        ((UserService) service).createResource(user);
    }

    @Override
    public void deleteResource(@RequestParam Long id) {
        if(id == null)
            throw new IllegalArgumentException("Invalid user id");

        ((UserService) service).deleteResource(id);
    }
}
