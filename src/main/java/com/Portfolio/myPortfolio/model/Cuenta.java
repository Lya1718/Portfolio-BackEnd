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
public class Cuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Basic
    private String email;
    private String password;

    public Cuenta() {
    }

    public Cuenta(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
