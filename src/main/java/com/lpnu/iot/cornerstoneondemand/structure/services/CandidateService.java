package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Candidate;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService extends GenericService<Candidate> {

    @Autowired
    public CandidateService(CandidateRepository userRepository) {
        super(userRepository);
    }
}
