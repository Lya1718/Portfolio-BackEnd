package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Exp_Laboral;
import java.util.List;

public interface IExpService {
    public List<Exp_Laboral> verExperiencias();
    public void guardarExp(Exp_Laboral exp);
    public void borrarExp(Long id);
    public Exp_Laboral buscarExp(Long id);
}
