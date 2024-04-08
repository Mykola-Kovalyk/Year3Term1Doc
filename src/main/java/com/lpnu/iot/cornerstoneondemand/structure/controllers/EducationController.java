package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Education;
import com.lpnu.iot.cornerstoneondemand.structure.services.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/educations")
public class EducationController extends GenericController<Education> {

    @Autowired
    public EducationController(EducationService service) {
        super(service, "educations");
    }
}
