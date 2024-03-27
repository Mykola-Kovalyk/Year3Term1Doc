package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.Resume;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.EducationRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.ResumeRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.SkillRepository;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.WorkExperienceRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService extends GenericService<Resume> {

    private WorkExperienceRepository workExperienceRepository;
    private EducationRepository educationRepository;
    private SkillRepository skillRepository;
    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository ResumeRepository, WorkExperienceRepository workExperienceRepository,
            EducationRepository educationRepository, SkillRepository skillRepository,
            ResumeRepository resumeRepository) {
        super(ResumeRepository);

        this.workExperienceRepository = workExperienceRepository;
        this.educationRepository = educationRepository;
        this.skillRepository = skillRepository;
        this.resumeRepository = resumeRepository;
    }


    public Map<String, Object> getFullResumeData(Long id) {
        Map<String, Object> resumeData = new HashMap<>();
        Resume resume = resumeRepository.findAny(res -> res.getId().equals(id));
        resumeData.put("resume", resume);

        if (resume == null) {
            return resumeData;
        }
        var candidateId = resume.getCandidateId();

        resumeData.put("workExperiences", workExperienceRepository.findAll(res -> res.getCandidateId().equals(candidateId)));
        resumeData.put("educations", educationRepository.findAll(res -> res.getCandidateId().equals(candidateId)));
        resumeData.put("skills", skillRepository.findAll(res -> res.getCandidateId().equals(candidateId)));
        return resumeData;
    }
}
