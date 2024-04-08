package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpnu.iot.cornerstoneondemand.resources.Resource;
import com.lpnu.iot.cornerstoneondemand.structure.services.GenericService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class GenericController<Res extends Resource> {

    protected GenericService<Res> service;
    protected String resourceName;

    public GenericController(GenericService<Res> service, String resourceName) {
        this.service = service;
        this.resourceName = resourceName;
    }

    @GetMapping(path = "/all")
    public String getResources(Model model) {

        var resources = service.getResources();

        model.addAttribute("resource_fields", resources.iterator().next().getFieldNames());
        model.addAttribute("resources", StreamSupport.stream(service.getResources().spliterator(), false)
                .map((res) -> {
                    return res.getFieldValues();
                }).toArray());
        model.addAttribute("res_name", resourceName);
        return "read_template";
    }

    @GetMapping(path = "/{resourceId}")
    public String getResource(@PathVariable Long resourceId, Model model) {

        Res resource;
        boolean exists = true;
        try {
            resource = service.getResource(resourceId);
            exists = true;
        } catch (Exception e) {
            resource = service.newResource();
            resource.setId(resourceId);
            exists = false;
        }

        model.addAttribute("resource_fields", resource.getFieldNames());
        model.addAttribute("resource", resource.getFieldValues());
        model.addAttribute("res_name", resourceName);
        model.addAttribute("exists", exists);

        return "view_template";
    }

    @GetMapping(path = "/add")
    public String addResource(Model model) {
        return getResource(Long.valueOf(-1), model);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addResource(@RequestParam MultiValueMap<String, String> resourceFields,
            Model model) {

        Res resource = service.newResource();

        resource.setId(Long.valueOf(-1));

        var names = resource.getFieldNames();
        var values = resource.getFieldValues();

        for (int i = 0; i < names.length; i++) {
            var value = resourceFields.get(names[i]);
            if (value != null && value.size() > 0)
                values[i] = value.get(0);
        }

        resource.setFieldValues(values);
        service.createResource(resource);

        model.addAttribute("resource_fields", resource.getFieldNames());
        model.addAttribute("resources", new String[][] { resource.getFieldValues() });
        model.addAttribute("res_name", resourceName);
        return "read_template";
    }

    @PostMapping(path = "/{resourceId}/edit", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateResource(@PathVariable Long resourceId,
            @RequestParam MultiValueMap<String, String> resourceFields,
            Model model) {
        Res resource = service.getResource(resourceId);

        if (resource == null) {
            return "redirect:/";
        }

        var names = resource.getFieldNames();
        var values = resource.getFieldValues();

        for (int i = 0; i < names.length; i++) {
            var value = resourceFields.get(names[i]);
            if (value != null && value.size() > 0)
                values[i] = value.get(0);
        }

        resource.setFieldValues(values);
        service.updateResource(resource);

        model.addAttribute("resource_fields", resource.getFieldNames());
        model.addAttribute("resources", new String[][] { resource.getFieldValues() });
        model.addAttribute("res_name", resourceName);
        return "read_template";
    }

    @DeleteMapping(path = "/{resourceId}")
    public String deleteResource(@PathVariable Long resourceId, Model model) {
        service.deleteResource(resourceId);
        return getResources(model);
    }
}
