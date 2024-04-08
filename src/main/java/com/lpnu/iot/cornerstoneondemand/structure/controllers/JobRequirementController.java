package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequirement;
import com.lpnu.iot.cornerstoneondemand.resources.JobRequirementType;
import com.lpnu.iot.cornerstoneondemand.structure.services.JobRequirementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/job_requirements")
public class JobRequirementController extends GenericController<JobRequirement> {

    @Autowired
    public JobRequirementController(JobRequirementService service) {
        super(service, "job_requirements");
    }
}
