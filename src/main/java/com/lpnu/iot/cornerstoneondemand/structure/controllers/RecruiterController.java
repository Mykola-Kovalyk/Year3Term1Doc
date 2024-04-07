package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Recruiter;
import com.lpnu.iot.cornerstoneondemand.structure.services.RecruiterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/recruiters")
public class RecruiterController extends GenericController<Recruiter> {

    @Autowired
    public RecruiterController(RecruiterService service) {
        super(service, "index");
    }

    @GetMapping("{managerId}/requisitions")
    public Object getRequisitions(@PathVariable Long managerId) {
        return ((RecruiterService) service).getRequisitions(managerId);
    }

    @PostMapping("add")
    public void addRecruiter(@PathVariable String department) throws Exception {
        if(department == null)
            throw new Exception("Invalid recruiter data");

        Recruiter recruiter = new Recruiter(department);
        ((RecruiterService) service).createResource(recruiter);
    }
}
