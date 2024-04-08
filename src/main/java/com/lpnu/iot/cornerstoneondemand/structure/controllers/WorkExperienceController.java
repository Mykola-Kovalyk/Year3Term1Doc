package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.WorkExperience;
import com.lpnu.iot.cornerstoneondemand.structure.services.WorkExperienceService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/work_experiences")
public class WorkExperienceController extends GenericController<WorkExperience> {

    @Autowired
    public WorkExperienceController(WorkExperienceService service) {
        super(service, "work_experiences");
    }

    @PostMapping("add")
    public String addWorkExperience(@PathVariable Long candidateId,
            @PathVariable String company,
            @PathVariable String position,
            @PathVariable Date startDate,
            @PathVariable Date endDate,
            @PathVariable String description, Model model) throws Exception {
        if (candidateId == null || company == null || position == null || startDate == null || endDate == null
                || description == null)
            throw new Exception("Invalid work experience data");

        WorkExperience workExperience = new WorkExperience(candidateId, company, position, startDate, endDate,
                description);
        ((WorkExperienceService) service).createResource(workExperience);

        return "redirect:/index";
    }
}
