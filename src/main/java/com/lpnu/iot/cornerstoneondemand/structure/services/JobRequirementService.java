package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequirement;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRequirementService extends GenericService<JobRequirement> {

    @Autowired
    public JobRequirementService(JobRequirementRepository userRepository) {
        super(userRepository);
    }
}
