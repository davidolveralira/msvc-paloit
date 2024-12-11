package com.dolvera.paloit.repository;

import com.dolvera.paloit.models.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<TechnologyEntity, Long> {
}
