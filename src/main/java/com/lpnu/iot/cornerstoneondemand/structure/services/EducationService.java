package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Education;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService extends GenericService<Education> {

    @Autowired
    public EducationService(EducationRepository EducationRepository) {
        super(EducationRepository);
    }
}
