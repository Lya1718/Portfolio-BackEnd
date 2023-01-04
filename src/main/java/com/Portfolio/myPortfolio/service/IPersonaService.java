package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersonas(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersonas(Long id);
}
