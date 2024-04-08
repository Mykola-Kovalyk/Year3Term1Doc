package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Skill;

import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository extends CSVRepository<Skill> {

    public SkillRepository() {
        super("skills");
    }
    
    @Override
    public Skill newResource() {
        return new Skill();
    }
}
