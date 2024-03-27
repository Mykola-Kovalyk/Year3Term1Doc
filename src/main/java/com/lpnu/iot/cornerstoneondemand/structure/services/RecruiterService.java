package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Recruiter;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService extends GenericService<Recruiter> {

    @Autowired
    public RecruiterService(RecruiterRepository userRepository) {
        super(userRepository);
    }
}
