package com.Portfolio.myPortfolio.repository;

import com.Portfolio.myPortfolio.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
}
