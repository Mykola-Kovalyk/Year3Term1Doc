package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.User;
import com.lpnu.iot.cornerstoneondemand.structure.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/users")
public class UserController extends GenericController<User> {

    @Autowired
    public UserController(UserService service) {
        super(service, "index");
    }

    @PostMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String phone, @RequestParam String email) throws Exception {
        if(name == null || phone == null || email == null)
            throw new Exception("Invalid user data");

        User user = new User(name, phone, email);
        ((UserService) service).createResource(user);
    }

    @Override
    public String deleteResource(@RequestParam Long id, Model model) {
        if(id == null)
            throw new IllegalArgumentException("Invalid user id");
        return super.deleteResource(id, model);
    }
}
