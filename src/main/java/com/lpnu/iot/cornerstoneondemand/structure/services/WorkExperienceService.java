package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.WorkExperience;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceService extends GenericService<WorkExperience> {

    @Autowired
    public WorkExperienceService(WorkExperienceRepository WorkExperienceRepository) {
        super(WorkExperienceRepository);
    }
}
