package com.misiontic.proyectociclo3.Controllers;

import com.misiontic.proyectociclo3.Models.Especialistas;
import com.misiontic.proyectociclo3.Services.EspecialistasService;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/especialistas")
public class EspecialistasController {

    @Autowired
    private EspecialistasService especialistasservice;

    @PostMapping(value = "/")
    public ResponseEntity<Especialistas> agregar(@RequestBody Especialistas especialistas) {
        Especialistas obj = especialistasservice.save(especialistas);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Especialistas> eliminar(@PathVariable Integer id) {
        Especialistas obj = especialistasservice.findById(id);
        if (obj != null) {
            especialistasservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Especialistas> editar(@RequestBody Especialistas especialistas) {
        Especialistas obj = especialistasservice.findById(especialistas.getIdEspecialistas());
        if (obj != null) {
            obj.setEspecialidad(especialistas.getEspecialidad());
            obj.setNombre(especialistas.getNombre());
            obj.setApellidos(especialistas.getApellidos());
            obj.setDisponibilidad(especialistas.getDisponibiliad());
            especialistasservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Especialistas> consultarTodo() {
        return especialistasservice.findAll();
    }

    @GetMapping("/list/{id}")
    public Especialistas consultarPorId(@PathVariable Integer id) {
        return especialistasservice.findById(id);
    }
}
