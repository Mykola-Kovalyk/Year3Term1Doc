package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Skill;

import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository extends CSVRepository<Skill> {
    @Override
    protected Skill createNewResource() {
        return new Skill();
    }
}
