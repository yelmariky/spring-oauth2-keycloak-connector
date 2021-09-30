package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
@SecurityRequirement(name = "security_auth")
class HeroesController {
    private HeroesRepository repository;

    public HeroesController(HeroesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/aaheroes")
    public Collection<Heroes> coolCars() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

  
}
