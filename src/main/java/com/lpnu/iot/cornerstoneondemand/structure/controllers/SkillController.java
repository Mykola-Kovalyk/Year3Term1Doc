package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Skill;
import com.lpnu.iot.cornerstoneondemand.resources.SkillLevel;
import com.lpnu.iot.cornerstoneondemand.structure.services.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillController extends GenericController<Skill> {

    @Autowired
    public SkillController(SkillService service) {
        super(service);
    }

    @PostMapping("add")
    public void addSkill(@PathVariable Long candidateId, @PathVariable String name, @PathVariable String level) throws Exception {
        if(name == null)
            throw new Exception("Invalid skill data");

        Skill skill = new Skill(candidateId, name, SkillLevel.valueOf(level));
        ((SkillService) service).createResource(skill);
    }
}
