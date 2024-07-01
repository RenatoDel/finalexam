package com.example.finalexam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="plataformas")
public class Distribuidora{
    @Id
    @Column(name = "idplataforma", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "idplataforma",length = 200)
    private String descripcion;
}
