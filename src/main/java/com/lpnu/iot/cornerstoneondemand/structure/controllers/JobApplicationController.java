package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.ApplicationStatus;
import com.lpnu.iot.cornerstoneondemand.resources.JobApplication;
import com.lpnu.iot.cornerstoneondemand.structure.services.JobApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job_applications")
public class JobApplicationController extends GenericController<JobApplication> {

    @Autowired
    public JobApplicationController(JobApplicationService service) {
        super(service);
    }

    @PostMapping("apply")
    public void applyForJob(@PathVariable Long candidateId, @PathVariable Long jobId) {

        ((JobApplicationService) service).applyForJob(candidateId, jobId);
    }

    @PostMapping("{id}/status")
    public void updateStatus(@PathVariable Long id, @PathVariable String status) {
        if (status == null)
            throw new IllegalArgumentException("Invalid status data.");

        ((JobApplicationService) service).changeApplicationStatus(id, ApplicationStatus.valueOf(status));
    }
}
