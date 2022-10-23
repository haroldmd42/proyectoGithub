/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.proyectociclo3.Services.Implement;

import com.misiontic.proyectociclo3.Dao.UsuariosDao;
import com.misiontic.proyectociclo3.Models.UsuariosRegistrados;
import com.misiontic.proyectociclo3.Services.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kevin
 */
@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosDao usuariosDao;

    @Override
    @Transactional(readOnly=false)
    public UsuariosRegistrados save(UsuariosRegistrados usuariosregistrados) {
        return usuariosDao.save(usuariosregistrados);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        usuariosDao.deleteById(id);
    }
       

    @Override
    @Transactional(readOnly=true)
    public UsuariosRegistrados findById(Integer id){
        return usuariosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<UsuariosRegistrados> findAll(){
        return (List<UsuariosRegistrados>) usuariosDao.findAll();
    }
    
}
