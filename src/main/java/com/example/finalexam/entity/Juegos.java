package com.example.finalexam.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="juegos")
public class Juegos {
    @Id
    @Column(name = "idjuego", nullable = false)
    private Integer id;

    @Column(name ="nombre", length = 50)
    private String nombre;
    @Column(name ="descripcion", length = 448)
    private String descripcion;
    @Column(name ="precio", length = 50)
    private String precio;
    @Column(name ="image", length = 400)
    private String image;

    @ManyToOne
    @Column(name="idgenero")
    private String idgenero;

    @ManyToOne
    @Column(name="idplataforma")
    private String idplataforma;
    @ManyToOne
    @Column(name="ideditora")
    private String ideditora;
    @ManyToOne
    @Column(name="iddistribuidora")
    private String iddistribuidora;

}
