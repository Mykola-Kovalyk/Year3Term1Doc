package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.resources.Recruiter;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobRequisitionRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService extends GenericService<Recruiter> {


    private JobRequisitionRepository jobRequisitionRepository;

    @Autowired
    public RecruiterService(RecruiterRepository userRepository, JobRequisitionRepository jobRequisitionRepository) {
        super(userRepository);

        this.jobRequisitionRepository = jobRequisitionRepository;
    }

    public Iterable<JobRequisition> getRequisitions(Long managerId) {
        return jobRequisitionRepository.findAll(res -> res.getRequisitionManagerId().equals(managerId)).values();
    }
}
