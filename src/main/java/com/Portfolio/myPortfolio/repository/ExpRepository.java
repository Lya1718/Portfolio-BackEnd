package com.Portfolio.myPortfolio.repository;

import com.Portfolio.myPortfolio.model.Exp_Laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpRepository extends JpaRepository <Exp_Laboral, Long>{
    
}
