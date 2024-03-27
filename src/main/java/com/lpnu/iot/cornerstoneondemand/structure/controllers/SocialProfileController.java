package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.SocialProfile;
import com.lpnu.iot.cornerstoneondemand.structure.services.SocialProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social_profiles")
public class SocialProfileController extends GenericController<SocialProfile> {

    @Autowired
    public SocialProfileController(SocialProfileService service) {
        super(service);
    }

    @PostMapping("add")
    public void addSocialProfile(@PathVariable Long candidateId, @PathVariable String platform, @PathVariable String profileUrl) throws Exception {
        if(candidateId == null || platform == null || profileUrl == null)
            throw new Exception("Invalid social profile data");

        SocialProfile socialProfile = new SocialProfile(candidateId, platform, profileUrl);
        ((SocialProfileService) service).createResource(socialProfile);
    }
}
