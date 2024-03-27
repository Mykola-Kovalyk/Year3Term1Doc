package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.Resource;
import com.lpnu.iot.cornerstoneondemand.structure.services.GenericService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class GenericController<Res extends Resource> {

    protected GenericService<Res> service;

    public GenericController(GenericService<Res> service) {
        this.service = service;
    }

    @GetMapping(path = "/all")
    public Iterable<Res> getResources() {
        return service.getResources();
    }

    @GetMapping(path = "/{resourceId}")
    public Res getResource(@PathVariable Long resourceId) {
        return service.getResource(resourceId);
    }

    @DeleteMapping(path = "/{resourceId}")
    public void deleteResource(@PathVariable Long resourceId) {
        service.deleteResource(resourceId);
    }
}
