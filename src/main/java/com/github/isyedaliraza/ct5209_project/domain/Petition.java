package com.github.isyedaliraza.ct5209_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "petition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Signature> signatures = new ArrayList<>();

    public Petition() {}

    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
