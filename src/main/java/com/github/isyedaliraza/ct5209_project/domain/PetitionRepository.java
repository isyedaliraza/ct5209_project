package com.github.isyedaliraza.ct5209_project.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetitionRepository extends CrudRepository<Petition, Long> {
    List<Petition> findByTitleContainingIgnoreCase(String q);
}
