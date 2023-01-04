package com.Portfolio.myPortfolio.security.service;

import com.Portfolio.myPortfolio.security.model.Usuario;
import com.Portfolio.myPortfolio.security.model.UsuarioMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


 //Clase que convierte la clase usuario en un UsuarioMain
 //UserDetailsService es propia de Spring Security

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuServ;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuServ.getByUsuario(nombreUsuario).get();
        return UsuarioMain.build(usuario);
    }
}
