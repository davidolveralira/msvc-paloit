package com.dolvera.paloit.consumer.controller;

import com.dolvera.paloit.models.entity.TechnologyEntity;
import com.dolvera.paloit.services.TechnologyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologyController {

    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping
    public List<TechnologyEntity> getAllTechnologies() {
        return service.getAllTechnologies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyEntity> getTechnologyById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTechnologyById(id));
    }

    @PostMapping
    public ResponseEntity<List<TechnologyEntity>> createTechnologies(@RequestBody List<TechnologyEntity> technologies) {
        List<TechnologyEntity> savedTechnologies = technologies.stream()
                .map(service::saveTechnology)
                .toList();
        return ResponseEntity.ok(savedTechnologies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyEntity> updateTechnology(@PathVariable Long id, @RequestBody TechnologyEntity technology) {
        return ResponseEntity.ok(service.updateTechnology(id, technology));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        service.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}
