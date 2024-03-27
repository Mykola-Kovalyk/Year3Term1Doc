package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Resume;
import com.lpnu.iot.cornerstoneondemand.structure.services.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumes")
public class ResumeController extends GenericController<Resume> {

    @Autowired
    public ResumeController(ResumeService service) {
        super(service);
    }
}
