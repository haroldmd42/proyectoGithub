package com.misiontic.proyectociclo3.Dao;

import com.misiontic.proyectociclo3.Models.Especialistas;
import org.springframework.data.repository.CrudRepository;

public interface EspecialistasDao extends 
        CrudRepository<Especialistas,Integer> {
    
}
