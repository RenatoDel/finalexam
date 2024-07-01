package com.example.finalexam.dto;

import com.example.finalexam.entity.Juegos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuegosDto {
    private String result;
    private String msg;
    private Juegos juegos;
}