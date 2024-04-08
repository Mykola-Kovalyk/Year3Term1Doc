package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.WorkExperience;

import org.springframework.stereotype.Repository;

@Repository
public class WorkExperienceRepository extends CSVRepository<WorkExperience> {

    public WorkExperienceRepository() {
        super("work_experiences");
    }

    @Override
    public WorkExperience newResource() {
        return new WorkExperience();
    }
}
