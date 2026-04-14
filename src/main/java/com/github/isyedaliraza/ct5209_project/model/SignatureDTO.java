package com.github.isyedaliraza.ct5209_project.model;

import com.github.isyedaliraza.ct5209_project.domain.Signature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignatureDTO {
    private Long id;
    private String name;
    private String email;

    public SignatureDTO(Signature signature) {
        this.id = signature.getId();
        this.name = signature.getName();
        this.email = signature.getEmail();
    }
}
