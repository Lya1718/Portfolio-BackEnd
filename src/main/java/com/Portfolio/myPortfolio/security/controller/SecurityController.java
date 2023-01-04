package com.Portfolio.myPortfolio.security.controller;


import com.Portfolio.myPortfolio.security.dto.JwtDto;
import com.Portfolio.myPortfolio.security.dto.LoginUsuario;
import com.Portfolio.myPortfolio.security.dto.NuevoUsuario;
import com.Portfolio.myPortfolio.security.model.Rol;
import com.Portfolio.myPortfolio.security.model.Usuario;
import com.Portfolio.myPortfolio.security.enums.RolNombre;
import com.Portfolio.myPortfolio.security.jwt.JwtProvider;
import com.Portfolio.myPortfolio.security.service.RolService;
import com.Portfolio.myPortfolio.security.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class SecurityController {

    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UsuarioService usuarioService;
    @Autowired RolService rolService;
    @Autowired JwtProvider jwtProvider;

    // espera un usuario para logearse
    
    //MYSQL_ADDON_HOST=bsfc4mprvpdsbvhgjnau-mysql.services.clever-cloud.com
    //MYSQL_ADDON_DB=bsfc4mprvpdsbvhgjnau
    //MYSQL_ADDON_USER=u5qse8uf9jhncbnm
    //MYSQL_ADDON_PORT=3306
    //MYSQL_ADDON_PASSWORD=iFTrusdWHUqyI9qCB4DV
    //MYSQL_ADDON_URI=mysql://u5qse8uf9jhncbnm:iFTrusdWHUqyI9qCB4DV@bsfc4mprvpdsbvhgjnau-mysql.services.clever-cloud.com:3306/bsfc4mprvpdsbvhgjnau
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
    //bindingResult object that holds the result of the validation and binding and contains errors that may have ocurred
    //binding: asociacion de valores con identificadores
    
    //crea un nuevo usuario, register
   //Espera un json y lo convierte a tipo clase NuevoUsuario
     @PostMapping("/nuevoUsuario")
     public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario,
                                           BindingResult bindingResult){
         if(bindingResult.hasErrors()){
             return new ResponseEntity<>(new Mensaje("Campos mal o email invalido"), HttpStatus.BAD_REQUEST);
         }
         if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
             return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
         }
         if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
             return new ResponseEntity<>(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
         }

         Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                 nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

         Set<Rol> roles = new HashSet<>();
         roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
         if(nuevoUsuario.getRoles().contains("admin"))
             roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
         usuario.setRoles(roles);

         usuarioService.save(usuario);

         return new ResponseEntity<>(new Mensaje("Usuario creado"), HttpStatus.CREATED);
    }

}