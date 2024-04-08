package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.SocialProfile;

import org.springframework.stereotype.Repository;

@Repository
public class SocialProfileRepository extends CSVRepository<SocialProfile> {

    public SocialProfileRepository() {
        super("social_profiles");
    }
    
    @Override
    public SocialProfile newResource() {
        return new SocialProfile();
    }
}
