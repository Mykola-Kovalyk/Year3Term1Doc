package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequirement;
import org.springframework.stereotype.Repository;

@Repository
public class JobRequirementRepository extends CSVRepository<JobRequirement> {

    @Override
    protected JobRequirement createNewResource() {
        return new JobRequirement();
    }
}
