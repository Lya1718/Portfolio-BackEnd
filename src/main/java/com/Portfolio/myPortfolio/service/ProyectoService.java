package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Proyecto;
import com.Portfolio.myPortfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired ProyectoRepository proyeRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        return proyeRepo.findAll();
    }

    @Override
    public void guardarProyecto(Proyecto pro) {
        proyeRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyeRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyectos(Long id) {
        return proyeRepo.findById(id).orElse(null);
    }
    
}
