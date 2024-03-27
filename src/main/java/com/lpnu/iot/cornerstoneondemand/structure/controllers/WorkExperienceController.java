package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.WorkExperience;
import com.lpnu.iot.cornerstoneondemand.structure.services.WorkExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work_experiences")
public class WorkExperienceController extends GenericController<WorkExperience> {

    @Autowired
    public WorkExperienceController(WorkExperienceService service) {
        super(service);
    }
}
