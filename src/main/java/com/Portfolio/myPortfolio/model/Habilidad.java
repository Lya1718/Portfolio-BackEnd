package com.Portfolio.myPortfolio.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Basic
    private String habilidad;
    private int nivel;

    public Habilidad() {
    }

    public Habilidad(Long id, String habilidad, int nivel) {
        this.id = id;
        this.habilidad = habilidad;
        this.nivel = nivel;
    }
}
