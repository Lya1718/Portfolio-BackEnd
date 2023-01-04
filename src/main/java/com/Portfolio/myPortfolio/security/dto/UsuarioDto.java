package com.Portfolio.myPortfolio.security.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDto implements Serializable{
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
           
}