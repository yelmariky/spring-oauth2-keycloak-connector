package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Heroes Entity")
@RepositoryRestResource(path = "heroes")
@SecurityRequirement(name = "security_auth")
interface HeroesRepository extends JpaRepository<Heroes, Long> {
}
