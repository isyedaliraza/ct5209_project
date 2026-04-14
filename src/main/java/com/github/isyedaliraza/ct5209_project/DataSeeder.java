package com.github.isyedaliraza.ct5209_project;

import com.github.isyedaliraza.ct5209_project.domain.Petition;
import com.github.isyedaliraza.ct5209_project.domain.PetitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PetitionRepository repository;

    public DataSeeder(PetitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() == 0) { // avoid duplicate seeding

            repository.save(new Petition(
                    "Save the Environment",
                    "We must reduce plastic usage and protect oceans."
            ));

            repository.save(new Petition(
                    "Improve Public Transport",
                    "Increase bus frequency and reduce ticket prices."
            ));

            repository.save(new Petition(
                    "Better Internet Access",
                    "Affordable high-speed internet for everyone."
            ));

            System.out.println("✅ Database seeded successfully!");
        }
    }
}
