package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Education;
import com.lpnu.iot.cornerstoneondemand.structure.services.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Educations")
public class EducationController extends GenericController<Education> {

    @Autowired
    public EducationController(EducationService service) {
        super(service);
    }
}
