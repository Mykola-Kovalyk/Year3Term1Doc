package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.JobRequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRequisitionService extends GenericService<JobRequisition> {

    @Autowired
    public JobRequisitionService(JobRequisitionRepository JobRequisitionRepository) {
        super(JobRequisitionRepository);
    }
}
