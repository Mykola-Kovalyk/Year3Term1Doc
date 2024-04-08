package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequirement;
import org.springframework.stereotype.Repository;

@Repository
public class JobRequirementRepository extends CSVRepository<JobRequirement> {

    public JobRequirementRepository() {
        super("job_requirements");
    }

    @Override
    public JobRequirement newResource() {
        return new JobRequirement();
    }
}
