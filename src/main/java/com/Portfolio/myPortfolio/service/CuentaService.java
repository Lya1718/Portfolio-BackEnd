package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Cuenta;
import com.Portfolio.myPortfolio.repository.CuentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService implements ICuentaService{

    @Autowired CuentaRepository ctaRepo;
    
    @Override
    public List<Cuenta> verCuenta() {
        return ctaRepo.findAll();
    }

    @Override
    public void guardarCuenta(Cuenta cta) {
        ctaRepo.save(cta);
    }

    @Override
    public void borrarCuenta(Long id) {
        ctaRepo.deleteById(id);
    }

    @Override
    public Cuenta buscarCuenta(Long id) {
        return ctaRepo.findById(id).orElse(null);
    }
    
}
