package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Candidate;
import com.lpnu.iot.cornerstoneondemand.structure.services.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/candidates")
public class CandidateController extends GenericController<Candidate> {

    @Autowired
    public CandidateController(CandidateService service) {
        super(service, "index");
    }

    @PostMapping("add")
    public void addCandidate(@PathVariable Long candidateId, @PathVariable Long jobId) {
        if (candidateId == null || jobId == null)
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Invalid data.");

        ((CandidateService) service).addCandidate(new Candidate(candidateId, jobId));
    }
}
