package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Skill;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService extends GenericService<Skill> {

    @Autowired
    public SkillService(SkillRepository SkillRepository) {
        super(SkillRepository);
    }
}
