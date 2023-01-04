package com.Portfolio.myPortfolio.security.service;

import com.Portfolio.myPortfolio.security.model.Usuario;
import com.Portfolio.myPortfolio.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired UsuarioRepository usuRepo;

    public Optional<Usuario> getByUsuario(String nombreUsuario){
        return usuRepo.findByNombreUsuario(nombreUsuario);
    }

    public Boolean existsByNombreUsuario(String nombreUsuario){
        return usuRepo.existsByNombreUsuario(nombreUsuario);
    }

    public Boolean existsByEmail(String email){
        return usuRepo.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuRepo.save(usuario);
    }
}