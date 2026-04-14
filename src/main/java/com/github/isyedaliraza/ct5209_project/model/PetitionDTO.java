package com.github.isyedaliraza.ct5209_project.model;

import com.github.isyedaliraza.ct5209_project.domain.Petition;
import com.github.isyedaliraza.ct5209_project.domain.Signature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetitionDTO {
    private Long id;
    private String title;
    private String description;
    private List<SignatureDTO> signatures = new ArrayList<>();

    public PetitionDTO(Petition petition) {
        this.id = petition.getId();
        this.title = petition.getTitle();
        this.description = petition.getDescription();
        this.signatures = new ArrayList<>();
        for (Signature signature: petition.getSignatures()) {
            this.signatures.add(new SignatureDTO(signature));
        }
    }
}
