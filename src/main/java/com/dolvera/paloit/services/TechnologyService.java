package com.dolvera.paloit.services;

import com.dolvera.paloit.models.entity.TechnologyEntity;
import com.dolvera.paloit.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    private final TechnologyRepository repository;

    public TechnologyService(TechnologyRepository repository) {
        this.repository = repository;
    }

    public List<TechnologyEntity> getAllTechnologies() {
        return repository.findAll();
    }

    public TechnologyEntity getTechnologyById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Technology not found"));
    }

    public TechnologyEntity saveTechnology(TechnologyEntity technology) {
        return repository.save(technology);
    }

    public List<TechnologyEntity> saveTechnologies(List<TechnologyEntity> technologies) {
        return repository.saveAll(technologies);
    }

    public TechnologyEntity updateTechnology(Long id, TechnologyEntity updatedTechnology) {
        TechnologyEntity existing = getTechnologyById(id);
        existing.setName(updatedTechnology.getName());
        existing.setType(updatedTechnology.getType());
        return repository.save(existing);
    }

    public void deleteTechnology(Long id) {
        repository.deleteById(id);
    }
}
