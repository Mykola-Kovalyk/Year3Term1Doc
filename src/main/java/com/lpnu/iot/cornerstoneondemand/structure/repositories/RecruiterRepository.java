package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Recruiter;
import org.springframework.stereotype.Repository;

@Repository
public class RecruiterRepository extends CSVRepository<Recruiter> {

    @Override
    protected Recruiter createNewResource() {
        return new Recruiter();
    }
}
