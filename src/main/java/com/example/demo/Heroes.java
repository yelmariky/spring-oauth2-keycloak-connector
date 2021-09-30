package com.example.demo;

import lombok.*;

import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.GeneratedValue;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
@Schema(name="heroes")
@Data
@NoArgsConstructor
public class Heroes {
    @Id @GeneratedValue
    @Schema(hidden = true)
    private Long id;
    
    private @NonNull String nombre;
    private @NonNull String bio;
    private @NonNull String img;
    private @NonNull LocalDate aparicion;
    private @NonNull String casa;
}
