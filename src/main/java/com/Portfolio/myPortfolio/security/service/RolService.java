package com.Portfolio.myPortfolio.security.service;

import com.Portfolio.myPortfolio.security.model.Rol;
import com.Portfolio.myPortfolio.security.enums.RolNombre;
import com.Portfolio.myPortfolio.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
//transactional es la persistencia, si queremos hacer un cambio y salió mal, hace que la base de datos vuelva a 
//su estado anterior
@Transactional
public class RolService {

    @Autowired RolRepository rolRepo;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return  rolRepo.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepo.save(rol);
    }
}