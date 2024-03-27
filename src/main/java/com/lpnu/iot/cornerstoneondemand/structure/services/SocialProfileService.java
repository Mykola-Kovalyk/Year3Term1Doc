package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.resources.SocialProfile;
import com.lpnu.iot.cornerstoneondemand.structure.repositories.SocialProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialProfileService extends GenericService<SocialProfile> {

    @Autowired
    public SocialProfileService(SocialProfileRepository SocialProfileRepository) {
        super(SocialProfileRepository);
    }
}
