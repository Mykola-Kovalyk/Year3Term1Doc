package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.SocialProfile;

import org.springframework.stereotype.Repository;

@Repository
public class SocialProfileRepository extends CSVRepository<SocialProfile> {
    @Override
    protected SocialProfile createNewResource() {
        return new SocialProfile();
    }
}
