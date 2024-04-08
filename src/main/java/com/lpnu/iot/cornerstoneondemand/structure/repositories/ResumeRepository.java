package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Resume;

import org.springframework.stereotype.Repository;

@Repository
public class ResumeRepository extends CSVRepository<Resume> {

    public ResumeRepository() {
        super("resumes");
    }
    
    @Override
    public Resume newResource() {
        return new Resume();
    }
}
