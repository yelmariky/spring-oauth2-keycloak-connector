package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.swagger.annotations.Api;

@Api(tags = "Heroes Entity")
@RepositoryRestResource(path = "heroes")
interface HeroesRepository extends JpaRepository<Heroes, Long> {
}
