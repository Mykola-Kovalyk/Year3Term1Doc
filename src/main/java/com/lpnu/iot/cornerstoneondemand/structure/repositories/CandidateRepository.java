package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Candidate;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepository extends CSVRepository<Candidate> {

    @Override
    protected Candidate createNewResource() {
        return new Candidate();
    }
}
