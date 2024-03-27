package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Resume;

import org.springframework.stereotype.Repository;

@Repository
public class ResumeRepository extends CSVRepository<Resume> {
    @Override
    protected Resume createNewResource() {
        return new Resume();
    }
}
