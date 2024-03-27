package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Resume;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService extends GenericService<Resume> {

    @Autowired
    public ResumeService(ResumeRepository ResumeRepository) {
        super(ResumeRepository);
    }
}
