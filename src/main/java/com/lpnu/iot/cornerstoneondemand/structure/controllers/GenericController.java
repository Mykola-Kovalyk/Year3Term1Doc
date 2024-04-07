package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Resource;
import com.lpnu.iot.cornerstoneondemand.structure.services.GenericService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class GenericController<Res extends Resource> {

    protected GenericService<Res> service;
    protected String resourceName;

    public GenericController(GenericService<Res> service, String resourceName) {
        this.service = service;
        this.resourceName = resourceName;
    }

    @GetMapping(path = "/all")
    public String getResources(Model model) {
        model.addAttribute(resourceName, service.getResources());
        return resourceName;
    }

    @GetMapping(path = "/{resourceId}")
    public String getResource(@PathVariable Long resourceId, Model model) {
        model.addAttribute("resource", service.getResource(resourceId));
        return resourceName;
    }

    @DeleteMapping(path = "/{resourceId}")
    public String deleteResource(@PathVariable Long resourceId, Model model) {
        service.deleteResource(resourceId);

        model.addAttribute(resourceName, resourceId);
        return "redirect:/";

    }
}
