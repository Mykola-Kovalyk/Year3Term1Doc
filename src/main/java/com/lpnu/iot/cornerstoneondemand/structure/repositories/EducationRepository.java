package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Education;

import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository extends CSVRepository<Education> {

    public EducationRepository() {
        super("educations");
    }
    
    @Override
    public Education newResource() {
        return new Education();
    }
}
