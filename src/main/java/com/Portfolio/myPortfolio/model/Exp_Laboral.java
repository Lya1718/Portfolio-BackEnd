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
public class Exp_Laboral {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @Basic
    private String empresa;
    private String cargo;
    private String fecha_inicio;
    private String fecha_fin;
    private String descripcion;

    public Exp_Laboral() {
    }

    public Exp_Laboral(int id, String empresa, String cargo, String fecha_inicio, String fecha_fin, String descripcion){
        this.id = id;
        this.empresa = empresa;
        this.cargo = cargo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }
}
