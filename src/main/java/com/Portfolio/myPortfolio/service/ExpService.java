package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Exp_Laboral;
import com.Portfolio.myPortfolio.repository.ExpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpService implements IExpService{

    @Autowired ExpRepository expRepo;
    
    @Override
    public List<Exp_Laboral> verExperiencias() {
        return expRepo.findAll();
    }

    @Override
    public void guardarExp(Exp_Laboral exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExp(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Exp_Laboral buscarExp(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
}
