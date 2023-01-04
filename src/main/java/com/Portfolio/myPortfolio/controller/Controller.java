package com.Portfolio.myPortfolio.controller;

import com.Portfolio.myPortfolio.model.Cuenta;
import com.Portfolio.myPortfolio.model.Educacion;
import com.Portfolio.myPortfolio.model.Exp_Laboral;
import com.Portfolio.myPortfolio.model.Habilidad;
import com.Portfolio.myPortfolio.model.Persona;
import com.Portfolio.myPortfolio.model.Proyecto;
import com.Portfolio.myPortfolio.service.ICuentaService;
import com.Portfolio.myPortfolio.service.IEducacionService;
import com.Portfolio.myPortfolio.service.IExpService;
import com.Portfolio.myPortfolio.service.IHabilidadService;
import com.Portfolio.myPortfolio.service.IPersonaService;
import com.Portfolio.myPortfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired IPersonaService persoServ;
    @Autowired IProyectoService proyeServ;
    @Autowired IExpService expServ;
    @Autowired IHabilidadService habServ;
    @Autowired IEducacionService eduServ;
    @Autowired ICuentaService ctaServ;
    
    @GetMapping ()
    public String hola(){
        return "Esto funcionaaaaa";
    }
    
    //-------------------------------------------------------------------------
    //PERSONA
    //-------------------------------------------------------------------------
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(Persona per){
        return persoServ.verPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN)")
    @PostMapping ("/new/persona")
    public void agregarPersona(@RequestBody Persona per){
        persoServ.crearPersonas(per);
    }
    
    @PreAuthorize("hasRole('ADMIN)")
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN)")
    @PutMapping ("/personas/editar/{id}")
    public Persona guardarPersona(@PathVariable Long id,
            @RequestParam ("nombre") String nuevoNombre,
            @RequestParam ("apellido") String nuevoApellido,
            @RequestParam ("edad") int nuevaEdad,
            @RequestParam ("url_correo") String nuevoCorreo,
            @RequestParam ("url_github") String nuevoGithub,
            @RequestParam ("url_fb") String nuevoFb,
            @RequestParam ("sobre_mi") String nuevoSobreMi){
        Persona person = persoServ.buscarPersonas(id);
        person.setNombre(nuevoNombre);
        person.setApellido(nuevoApellido);
        person.setEdad(nuevaEdad);
        person.setUrl_correo(nuevoCorreo);
        person.setUrl_github(nuevoGithub);
        person.setUrl_fb(nuevoFb);
        person.setSobre_mi(nuevoSobreMi);
        persoServ.crearPersonas(person);
        return person;
    }
    
    //-------------------------------------------------------------------------
    //PROYECTO
    //-------------------------------------------------------------------------
    
    @GetMapping ("/ver/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos(Proyecto pro){
        return proyeServ.verProyecto();
    }
    
    @PostMapping ("/new/proyecto")
    public void crearProyecto(@RequestBody Proyecto pro){
        proyeServ.guardarProyecto(pro);
    }
    
    @DeleteMapping ("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyeServ.borrarProyecto(id);
    }
    
    @PutMapping ("/proyectos/editar/{id}")
    public Proyecto guardarProyectos(@PathVariable Long id,
            @RequestParam ("nombre") String nuevoNombre,
            @RequestParam ("fecha") String nuevaFecha,
            @RequestParam ("descripcion") String nuevaDescripcion,
            @RequestParam ("url_image") String nuevaImage){
        
        Proyecto proyect = proyeServ.buscarProyectos(id);
        proyect.setNombre(nuevoNombre);
        proyect.setFecha(nuevaFecha);
        proyect.setDescripcion(nuevaDescripcion);
        proyect.setUrl_image(nuevaImage);
        proyeServ.guardarProyecto(proyect);
        
        return proyect;
    }

    //-------------------------------------------------------------------------
    //EXP_LABORAL
    //-------------------------------------------------------------------------
    
    @GetMapping ("/ver/experiencias")
    @ResponseBody
    public List<Exp_Laboral> verExperiencias(Exp_Laboral exp){
        return expServ.verExperiencias();
    }
    
    @PostMapping ("/new/experience")
    public void guardarExperiencia(@RequestBody Exp_Laboral exp){
        expServ.guardarExp(exp);
    }
    
    @DeleteMapping ("/delete/experience/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExp(id);
    }
    
    @PutMapping ("/experiences/editar/{id}")
    public Exp_Laboral editarExperiencia(@PathVariable Long id,
                @RequestParam ("empresa") String nuevaEmpresa,
                @RequestParam ("cargo") String nuevoCargo,
                @RequestParam ("fecha_inicio") String nuevaFechaInicio,
                @RequestParam ("fecha_fin") String nuevafechaFin,
                @RequestParam ("descripcion") String nuevadescripcion){
        
        Exp_Laboral expL = expServ.buscarExp(id);
        expL.setEmpresa(nuevaEmpresa);
        expL.setCargo(nuevoCargo);
        expL.setFecha_inicio(nuevaFechaInicio);
        expL.setFecha_fin(nuevafechaFin);
        expL.setDescripcion(nuevadescripcion);
        expServ.guardarExp(expL);
        return expL;
    }
    
    //-------------------------------------------------------------------------
    //HABILIDAD
    //-------------------------------------------------------------------------
    
    @GetMapping ("/ver/habilidades")
    @ResponseBody
    public List<Habilidad> verHabilidades(){
        return habServ.verHabilidades();
    }
    
    @PostMapping ("new/habilidad")
    public void guardarHabilidad(@RequestBody Habilidad hab){
        habServ.guardarHabilidad(hab);
    }
    
    @DeleteMapping ("delete/habilidad/{id}")
    public void borrarHabilidad(@PathVariable Long id){
        habServ.borrarHabilidad(id);
    }
    
    @PutMapping ("/habilidades/editar/{id}")
    public Habilidad editarHabilidad(@PathVariable Long id,
            @RequestParam ("habilidad") String nuevaHabilidad,
            @RequestParam ("nivel") int nuevoNivel){
        Habilidad habil = habServ.buscarHabilidad(id);
        habil.setHabilidad(nuevaHabilidad);
        habil.setNivel(nuevoNivel);
        habServ.guardarHabilidad(habil);
        return habil;
    }
    
    //-------------------------------------------------------------------------
    //EDUCATION
    //-------------------------------------------------------------------------
    
    @GetMapping ("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @PostMapping ("new/educacion")
    public void guardarEducacion(@RequestBody Educacion edu){
        eduServ.guardarEducacion(edu);
    }
    
    @DeleteMapping ("delete/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping ("/educacion/editar/{id}")
    public Educacion editarEducacion(@PathVariable Long id,
            @RequestParam ("institucion") String nuevaInstitucion,
            @RequestParam ("titulo") String nuevoTitulo,
            @RequestParam ("descripcion") String nuevaDescripcion){
        
        Educacion educ = eduServ.buscarEducacion(id);
        educ.setInstitucion(nuevaInstitucion);
        educ.setTitulo(nuevoTitulo);
        educ.setDescripcion(nuevaDescripcion);
        
        eduServ.guardarEducacion(educ);
        return educ;
    }
    
    //-------------------------------------------------------------------------
    //CUENTA
    //-------------------------------------------------------------------------
    
    @GetMapping ("/ver/cuenta")
    @ResponseBody
    public List<Cuenta> verCuenta(){
        return ctaServ.verCuenta();
    }
    
    @PostMapping ("/new/cuenta")
    public void guardarCuenta(@RequestBody Cuenta cta){
        ctaServ.guardarCuenta(cta);
    }
    
    @DeleteMapping ("/delete/cuenta/{}id")
    public void borrarCuenta(@PathVariable Long id){
        ctaServ.borrarCuenta(id);
    }
    
    @PutMapping ("cuenta/editar/{id}")
    public Cuenta editarCuenta(@PathVariable Long id,
            @RequestParam ("email") String nuevoEmail,
            @RequestParam ("password") String nuevaPassword){
        Cuenta cuent = ctaServ.buscarCuenta(id);
        cuent.setEmail(nuevoEmail);
        cuent.setPassword(nuevaPassword);
        ctaServ.guardarCuenta(cuent);
        return cuent;
    }
}