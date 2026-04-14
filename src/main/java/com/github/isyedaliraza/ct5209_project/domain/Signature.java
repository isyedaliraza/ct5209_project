package com.github.isyedaliraza.ct5209_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    private Petition petition;

    public Signature() {}

    public Signature(String name, String email, Petition petition) {
        this.name = name;
        this.email = email;
        this.petition = petition;
    }
}
