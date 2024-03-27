package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.structure.services.JobRequisitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job_requisitions")
public class JobRequisitionController extends GenericController<JobRequisition> {

    @Autowired
    public JobRequisitionController(JobRequisitionService service) {
        super(service);
    }
}
