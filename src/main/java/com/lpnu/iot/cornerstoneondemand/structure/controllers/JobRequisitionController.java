package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.structure.services.JobRequisitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/job_requisitions")
public class JobRequisitionController extends GenericController<JobRequisition> {

    @Autowired
    public JobRequisitionController(JobRequisitionService service) {
        super(service, "index");
    }

    @GetMapping("{requisitionId}/candidates")
    public Object getCandidates(@PathVariable Long requisitionId) {
        return ((JobRequisitionService) service).getCandidates(requisitionId);
    }

    @PostMapping("add")
    public void addRequisition(@PathVariable Long managerId, @PathVariable String title, @PathVariable String description, @PathVariable String location) throws Exception {
        if(managerId == null || title == null || description == null)
            throw new Exception("Invalid requisition data");

        JobRequisition requisition = new JobRequisition(title, location, description, managerId);
        ((JobRequisitionService) service).createResource(requisition);
    }

}
