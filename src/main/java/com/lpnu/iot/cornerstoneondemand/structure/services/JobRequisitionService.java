package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Candidate;
import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.CandidateRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobRequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRequisitionService extends GenericService<JobRequisition> {

    private JobRequisitionRepository repository;
    private CandidateRepository candidateRepository;

    @Autowired
    public JobRequisitionService(JobRequisitionRepository JobRequisitionRepository,
            CandidateRepository candidateRepository) {
        super(JobRequisitionRepository);

        this.repository = JobRequisitionRepository;
        this.candidateRepository = candidateRepository;
    }

    public Iterable<Candidate> getCandidates(Long requisitionId) {
        return candidateRepository.findAll(res -> res.getJobId().equals(requisitionId)).values();
    }
}
