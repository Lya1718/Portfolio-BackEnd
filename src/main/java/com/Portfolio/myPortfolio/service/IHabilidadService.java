package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> verHabilidades();
    public void guardarHabilidad(Habilidad hab);
    public void borrarHabilidad(Long id);
    public Habilidad buscarHabilidad(Long id);
}
