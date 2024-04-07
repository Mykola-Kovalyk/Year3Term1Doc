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
        super(service, "index");
    }

    @PostMapping("add")
    public void addEducation(@PathVariable Long candidateId, @PathVariable String institution,
            @PathVariable String degree,
            @PathVariable String major, @PathVariable String startDate, @PathVariable Integer graduationYear) {
        if (candidateId == null || institution == null || degree == null || major == null || startDate == null
                || graduationYear == null)
            throw new IllegalArgumentException("Invalid education data");

        ((EducationService) service)
                .createResource(new Education(candidateId, institution, degree, major, graduationYear));
    }
}
