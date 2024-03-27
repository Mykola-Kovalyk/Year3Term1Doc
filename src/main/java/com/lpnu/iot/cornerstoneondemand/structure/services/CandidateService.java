package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Candidate;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.CandidateRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobApplicationRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService extends GenericService<Candidate> {

    private UserRepository userRepository;
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    public CandidateService(CandidateRepository repository, UserRepository userRepository,
            JobApplicationRepository jobApplicationRepository) {
        super(repository);

        this.userRepository = userRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public Iterable<Candidate> getCandidates(Long requisitionId) {
        return repository.findAll(res -> res.getJobId().equals(requisitionId)).values();
    }

    public void addCandidate(Candidate candidate) {

        if (userRepository.findById(candidate.getUserId()) == null)
            throw new IllegalArgumentException("Invalid candidate data");

        if (jobApplicationRepository.findById(candidate.getJobId()) == null)
            throw new IllegalArgumentException("Invalid job data");

        createResource(candidate);
    }
}
