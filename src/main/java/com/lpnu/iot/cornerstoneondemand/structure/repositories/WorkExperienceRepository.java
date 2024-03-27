package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.WorkExperience;

import org.springframework.stereotype.Repository;

@Repository
public class WorkExperienceRepository extends CSVRepository<WorkExperience> {
    @Override
    protected WorkExperience createNewResource() {
        return new WorkExperience();
    }
}
