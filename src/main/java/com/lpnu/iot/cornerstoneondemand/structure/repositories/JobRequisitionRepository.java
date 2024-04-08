package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.JobRequisition;

import org.springframework.stereotype.Repository;

@Repository
public class JobRequisitionRepository extends CSVRepository<JobRequisition> {

    public JobRequisitionRepository() {
        super("job_requisitions");
    }
    
    @Override
    public JobRequisition newResource() {
        return new JobRequisition();
    }
}
