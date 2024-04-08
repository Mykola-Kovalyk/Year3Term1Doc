package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.JobApplication;

import org.springframework.stereotype.Repository;

@Repository
public class JobApplicationRepository extends CSVRepository<JobApplication> {

    public JobApplicationRepository() {
        super("job_applications");
    }
    
    @Override
    public JobApplication newResource() {
        return new JobApplication();
    }
}
