package com.github.isyedaliraza.ct5209_project.service;

import com.github.isyedaliraza.ct5209_project.domain.Petition;
import com.github.isyedaliraza.ct5209_project.domain.PetitionRepository;
import com.github.isyedaliraza.ct5209_project.model.PetitionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {
    private final PetitionRepository petitionRepository;

    public PetitionService(PetitionRepository petitionRepository) {
        this.petitionRepository = petitionRepository;
    }

    public List<PetitionDTO> findAll() {
        List<PetitionDTO> petitions = new ArrayList<>();
        for (Petition petition : petitionRepository.findAll()) {
            petitions.add(new PetitionDTO(petition));
        }
        return petitions;
    }

    public List<PetitionDTO> findByTitle(String q) {
        List<PetitionDTO> petitions = new ArrayList<>();
        for (Petition petition: petitionRepository.findByTitleContainingIgnoreCase(q)) {
            petitions.add(new PetitionDTO(petition));
        }
        return petitions;
    }

    @Transactional
    public PetitionDTO save(String title, String description) {
        Petition petition = new Petition(title, description);
        petition = petitionRepository.save(petition);
        return new PetitionDTO(petition);
    }
}
