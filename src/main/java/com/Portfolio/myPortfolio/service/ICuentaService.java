package com.Portfolio.myPortfolio.service;

import com.Portfolio.myPortfolio.model.Cuenta;
import java.util.List;

public interface ICuentaService {
    public List<Cuenta> verCuenta();
    public void guardarCuenta(Cuenta cta);
    public void borrarCuenta(Long id);
    public Cuenta buscarCuenta(Long id);
}
