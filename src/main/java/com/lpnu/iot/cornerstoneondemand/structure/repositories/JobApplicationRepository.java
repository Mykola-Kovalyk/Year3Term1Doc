package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.JobApplication;

import org.springframework.stereotype.Repository;

@Repository
public class JobApplicationRepository extends CSVRepository<JobApplication> {
    @Override
    protected JobApplication createNewResource() {
        return new JobApplication();
    }
}
