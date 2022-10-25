package com.misiontic.proyectociclo3.Services.Implement;

import com.misiontic.proyectociclo3.Services.EspecialistasService;
import com.misiontic.proyectociclo3.Dao.EspecialistasDao;
import com.misiontic.proyectociclo3.Models.Especialistas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EspecialistasServiceImpl implements EspecialistasService {
    @Autowired
    private EspecialistasDao especialistasDao;
    
    @Override
    @Transactional(readOnly=false)
    public Especialistas save(Especialistas especialistas){
        return especialistasDao.save(especialistas);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        especialistasDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Especialistas findById(Integer id){
        return especialistasDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Especialistas> findAll(){
        return (List<Especialistas>) especialistasDao.findAll();
    }
}
