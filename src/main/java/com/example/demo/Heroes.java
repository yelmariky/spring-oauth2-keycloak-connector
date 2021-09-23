package com.example.demo;

import lombok.*;

import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
@ApiModel("heroes")
@Data
@NoArgsConstructor
public class Heroes {
    @Id @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id;
    
    private @NonNull String nombre;
    private @NonNull String bio;
    private @NonNull String img;
    private @NonNull LocalDate aparicion;
    private @NonNull String casa;
}
