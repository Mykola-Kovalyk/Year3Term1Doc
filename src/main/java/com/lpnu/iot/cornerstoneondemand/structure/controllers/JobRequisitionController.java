package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.structure.services.JobRequisitionService;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/job_requisitions")
public class JobRequisitionController extends GenericController<JobRequisition> {

    @Autowired
    public JobRequisitionController(JobRequisitionService service) {
        super(service, "job_requisitions");
    }

    @GetMapping("{requisitionId}/candidates")
    public String getCandidates(@PathVariable Long requisitionId, Model model) {
        var candidates = ((JobRequisitionService) service).getCandidates(requisitionId);

        model.addAttribute("resource_fields", candidates.iterator().next().getFieldNames());
        model.addAttribute("resources", StreamSupport.stream(candidates.spliterator(), false)
                .map((res) -> {
                    return res.getFieldValues();
                }).toArray());
        model.addAttribute("res_name", resourceName);
        return "read_template";
    }
}
