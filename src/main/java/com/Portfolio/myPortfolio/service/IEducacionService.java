package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();
    public void guardarEducacion(Educacion hab);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    
}
