package com.misiontic.proyectociclo3.Services;

import com.misiontic.proyectociclo3.Models.Especialistas;
import java.util.List;

public interface EspecialistasService {
    public Especialistas save(Especialistas especialistas);
    public void delete(Integer id);
    public Especialistas findById(Integer id);
    public List<Especialistas> findAll();
}
