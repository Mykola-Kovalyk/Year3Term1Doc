package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Resume;
import com.lpnu.iot.cornerstoneondemand.structure.services.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumes")
public class ResumeController extends GenericController<Resume> {

    @Autowired
    public ResumeController(ResumeService service) {
        super(service);
    }

    @GetMapping("{id}/full")
    public Object getFullResumeData(@PathVariable Long id) {
        return ((ResumeService) service).getFullResumeData(id);
    }


    @PostMapping("add") 
    public void addResume(@PathVariable Long candidateId) throws Exception {
        if(candidateId == null)
            throw new Exception("Invalid resume data");

        Resume resume = new Resume(candidateId);
        ((ResumeService) service).createResource(resume);
    }
}
