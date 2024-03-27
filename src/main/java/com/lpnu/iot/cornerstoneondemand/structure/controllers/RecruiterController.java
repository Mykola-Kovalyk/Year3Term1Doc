package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Recruiter;
import com.lpnu.iot.cornerstoneondemand.structure.services.RecruiterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController extends GenericController<Recruiter> {

    @Autowired
    public RecruiterController(RecruiterService service) {
        super(service);
    }
}
