/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.proyectociclo3.Controllers;

import com.misiontic.proyectociclo3.Models.UsuariosRegistrados;
import com.misiontic.proyectociclo3.Services.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;
    
    @PostMapping(value="/")
    public ResponseEntity<UsuariosRegistrados> agregar (@RequestBody UsuariosRegistrados usuariosregistrados){
        UsuariosRegistrados obj= usuariosService.save(usuariosregistrados);
        return new ResponseEntity<> (obj, HttpStatus.OK);         
    }
    
    @DeleteMapping(value = "/{id}")
     public ResponseEntity<UsuariosRegistrados> eliminar(@PathVariable Integer id) {
        UsuariosRegistrados obj = usuariosService.findById(id);
        if (obj != null) {
            usuariosService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
     }
     
     @PutMapping(value = "/")
    public ResponseEntity<UsuariosRegistrados> editar(@RequestBody UsuariosRegistrados usuariosregistrados) {
        UsuariosRegistrados obj = usuariosService.findById(usuariosregistrados.getIdusuario());
        if (obj != null) {
            obj.setNombres(usuariosregistrados.getNombres());
            obj.setApellidos(usuariosregistrados.getApellidos());
            obj.setEdad(usuariosregistrados.getEdad());
            obj.setDireccion(usuariosregistrados.getDireccion());
            obj.setTelefono(usuariosregistrados.getTelefono());
            obj.setCorreoElectronico(usuariosregistrados.getCorreoElectronico());
            obj.setContraseña(usuariosregistrados.getContraseña());            
            usuariosService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }   
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<UsuariosRegistrados> consultarTodo() {
        return usuariosService.findAll();
    }

    @GetMapping("/list/{id}")
    public UsuariosRegistrados consultarPorId(@PathVariable Integer id) {
        return usuariosService.findById(id);
    }
    
    
    
    
}
