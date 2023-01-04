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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Basic
    private String nombre;
    private String apellido;
    private int edad;
    private String url_correo;
    private String url_github;
    private String url_fb;
    private String url_portada;
    private String url_perfil;
    private String sobre_mi;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, int edad, String url_correo, String url_github, String url_fb, String url_portada, String url_perfil, String sobre_mi) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.url_correo = url_correo;
        this.url_github = url_github;
        this.url_fb = url_fb;
        this.url_portada = url_portada;
        this.url_perfil = url_perfil;
        this.sobre_mi = sobre_mi;
    }

    
    
}
