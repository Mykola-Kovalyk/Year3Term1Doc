package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.ApplicationStatus;
import com.lpnu.iot.cornerstoneondemand.resources.JobApplication;
import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobApplicationRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobRequisitionRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.ResumeRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService extends GenericService<JobApplication> {

    private ResumeRepository resumeRepository;
    private JobRequisitionRepository jobRequisitionRepository;

    @Autowired
    public JobApplicationService(JobApplicationRepository JobApplicationRepository, ResumeRepository resumeRepository,
            JobRequisitionRepository jobRequisitionRepository) {
        super(JobApplicationRepository);

        this.resumeRepository = resumeRepository;
        this.jobRequisitionRepository = jobRequisitionRepository;
    }

    public void applyForJob(Long candidateId, Long jobId) {

        JobApplication jobApplication = new JobApplication();
        jobApplication.setCandidateId(candidateId);
        jobApplication.setJobId(jobId);
        jobApplication.setStatus(ApplicationStatus.SUBMITTED);
        jobApplication.setApplicationDate(new Date());

        JobRequisition requisition = jobRequisitionRepository.findById(jobId);

        if (requisition == null) {
            throw new IllegalArgumentException("Job requisition not found");
        }

        if (resumeRepository.findById(candidateId) == null) {
            throw new IllegalArgumentException("Resume not found");
        }

        repository.add(jobApplication);
    }

    public void changeApplicationStatus(Long applicationId, ApplicationStatus status) {
        JobApplication application = repository.findById(applicationId);

        if (application == null)
            throw new IllegalArgumentException("Application not found");

        application.setStatus(status);
        repository.replace(application.getId(), application);
    }
}
