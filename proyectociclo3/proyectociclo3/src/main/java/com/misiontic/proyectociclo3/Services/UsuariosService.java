/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.proyectociclo3.Services;

import com.misiontic.proyectociclo3.Models.UsuariosRegistrados;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface UsuariosService {
public UsuariosRegistrados save(UsuariosRegistrados usuariosregistrados);
public void delete(Integer id);
public UsuariosRegistrados findById(Integer id);
public List<UsuariosRegistrados> findAll();
}

    