package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService{
    public List<Proyecto> verProyecto();
    public void guardarProyecto(Proyecto pro);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyectos(Long id);
}
