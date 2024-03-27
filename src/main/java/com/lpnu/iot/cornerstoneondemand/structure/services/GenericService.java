package com.lpnu.iot.cornerstoneondemand.structure.services;

import com.lpnu.iot.cornerstoneondemand.structure.repositories.CSVRepository;
import com.lpnu.iot.cornerstoneondemand.resources.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class GenericService<Res extends Resource> {

    protected CSVRepository<Res> repository;

    public GenericService(CSVRepository<Res> resourceRepository) {
        this.repository = resourceRepository;
    }

    public Iterable<Res> getResources() {
        return repository.findAll().entrySet().stream().map(entry -> entry.getValue()).toList();
    }

    public Res getResource(Long resourceId) {
        var found = repository.findById(resourceId);
        if (found == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "resource with id " + resourceId + "doesn't exist.");
        }

        return found;
    }

    public void createResource(Res resource) {
        repository.add(resource);
    }

    public void updateResource(Res resource) {
        repository.replace(resource.getId(), resource);
        try {
            repository.syncToFile();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save resource.");
        }
    }

    public void deleteResource(Long resourceId) {
        repository.remove(resourceId);

        try {
            repository.syncToFile();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save resource.");
        }
    }

}