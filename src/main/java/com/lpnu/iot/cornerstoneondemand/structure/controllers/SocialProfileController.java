package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.SocialProfile;
import com.lpnu.iot.cornerstoneondemand.structure.services.SocialProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/social_profiles")
public class SocialProfileController extends GenericController<SocialProfile> {

    @Autowired
    public SocialProfileController(SocialProfileService service) {
        super(service, "social_profiles");
    }
}
