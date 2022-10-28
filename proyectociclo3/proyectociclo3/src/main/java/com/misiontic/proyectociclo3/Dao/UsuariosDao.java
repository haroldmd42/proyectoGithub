/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.proyectociclo3.Dao;

import com.misiontic.proyectociclo3.Models.UsuariosRegistrados;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kevin
 */
public interface UsuariosDao extends 
        CrudRepository<UsuariosRegistrados,Integer>{
}
